package com.javierpinya.testcamiones_v2.ui;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.javierpinya.testcamiones_v2.Clases.TacprcoEntity;
import com.javierpinya.testcamiones_v2.Clases.UsuarioEntity;
import com.javierpinya.testcamiones_v2.NuevoUsuarioDialogViewModel;
import com.javierpinya.testcamiones_v2.R;
import com.javierpinya.testcamiones_v2.TacprcoViewModel;
import com.opencsv.CSVReader;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SincronizarFragment extends Fragment {

    private static final int READ_REQUEST_CODE = 1000;
    private Button btnSincronizar;
    private Button btnLeerBD;
    private EditText etTexto;
    private TacprcoViewModel tacprcoViewModel;
    private NuevoUsuarioDialogViewModel mViewModel;
    private List<TacprcoEntity> tractoras = new ArrayList<>();
    private List<UsuarioEntity> usuarios = new ArrayList<>();
    private List<String> matricula = new ArrayList<>();
    private List<Integer> tara = new ArrayList<>();
    private final String filename = "prueba_testcamiones";
    private final String content = "E2474JNZ;18000;24000;"+"\n" + "E0000AAA;9000;12000;";
    private final String path = "/storage/emulated/0/Download/TestCamiones/";


    public SincronizarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tacprcoViewModel = ViewModelProviders.of(getActivity()).get(TacprcoViewModel.class);
        mViewModel = ViewModelProviders.of(getActivity()).get(NuevoUsuarioDialogViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sincronizar, container, false);
        btnSincronizar = view.findViewById(R.id.btnSync);
        btnLeerBD = view.findViewById(R.id.btnLeerBD);
        etTexto = view.findViewById(R.id.etHelpSync);



        NuevoUsuarioDialogViewModel mViewModel = ViewModelProviders.of(getActivity()).get(NuevoUsuarioDialogViewModel.class);
        mViewModel.insertarUsuario(new UsuarioEntity("juan", "juan"));

        TacprcoViewModel tacprcoViewModel = ViewModelProviders.of(getActivity()).get(TacprcoViewModel.class);
        tacprcoViewModel.insertTacprco(new TacprcoEntity("E2474JNZ", 5210, 18000,121212,"T","E"));
        tacprcoViewModel.insertTacprco(new TacprcoEntity("E2400AAA", 5310, 18000,121213,"T","E"));
        tacprcoViewModel.insertTacprco(new TacprcoEntity("E2401BBB", 5410, 18000,121214,"T","E"));

        btnSincronizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lanzarViewModel();
               // NuevoUsuarioDialogViewModel mViewModel = ViewModelProviders.of(getActivity()).get(NuevoUsuarioDialogViewModel.class);
               // mViewModel.insertarUsuario(new UsuarioEntity("juan", "juan"));

               // TacprcoViewModel tacprcoViewModel = ViewModelProviders.of(getActivity()).get(TacprcoViewModel.class);
               // tacprcoViewModel.insertTacprco(new TacprcoEntity("E2474JNZ", 5210, 18000,121212,"T","E"));
                //tacprcoViewModel.insertTacprco(new TacprcoEntity("E2400AAA", 5310, 18000,121213,"T","E"));
                //tacprcoViewModel.insertTacprco(new TacprcoEntity("E2401BBB", 5410, 18000,121214,"T","E"));

                //performFileSearch();
                saveTextAsFile(filename,content);
            }
        });

        btnLeerBD.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String cadena="";
                List resultado = new ArrayList();
                //resultado = leerArchivo("hola");
                cadena = leerArchivo("hola");
               /*
                for (int i=0;i<resultado.size();i++){
                    cadena += resultado.get(i);
                }

                */

                etTexto.setText(cadena);

                if(usuarios.size()>0){
                    //Toast.makeText(getActivity(), usuarios.size(), Toast.LENGTH_SHORT).show();
                   // etTexto.setText(usuarios.get(0).getUsuario());
                }
                if(tractoras.size()>0){
                    for (int i=0;i<tractoras.size();i++){
                        matricula.add(tractoras.get(i).getMatricula());
                        tara.add(tractoras.get(i).getTara());
                    }
                    //etTexto.setText(tractoras.get(0).getMatricula());
                }
            }
        });

        return view;
    }

    private void lanzarViewModel(){

        mViewModel = ViewModelProviders.of(getActivity()).get(NuevoUsuarioDialogViewModel.class);
        mViewModel.getAllUsuarios().observe(getActivity(), new Observer<List<UsuarioEntity>>() {
            @Override
            public void onChanged(List<UsuarioEntity> usuarioEntities) {
                usuarios = usuarioEntities;
            }
        });

        tacprcoViewModel = ViewModelProviders.of(getActivity()).get(TacprcoViewModel.class);
        tacprcoViewModel.getAllTacprco().observe(getActivity(), new Observer<List<TacprcoEntity>>() {
            @Override
            public void onChanged(List<TacprcoEntity> tacprcoEntities) {
                tractoras = tacprcoEntities;
            }
        });
    }

    // Read content of the file
    private String leerArchivo(String input){
        File file = new File(path, filename + ".csv");
        StringBuilder text = new StringBuilder();
        String texto="";
        List resultList = new ArrayList();
        int i=0;
        try{
            CSVReader reader = new CSVReader(new FileReader(file));
            String [] nextLine;
            while ((nextLine = reader.readNext()) != null){

                i=i+1;
                text.append(nextLine);
                texto=nextLine[0];

            }

            /*
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){
                String[] row = line.split(";");
                text.append(row);
                text.append("\n");
                resultList.add(row);
            }
            br.close();
             */

        }catch (IOException e){
            e.printStackTrace();
        }
        return  texto;
    }

    //Select file from storate
    private void performFileSearch(){
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/*");
        startActivityForResult(intent, READ_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            if(data != null){
                Uri uri = data.getData();
                String path = uri.getPath();
                path = path.substring(path.indexOf(":") + 1);
                Toast.makeText(getActivity(), "" + path, Toast.LENGTH_SHORT).show();
               // etTexto.setText(leerArchivo(path));
            }
        }
    }

    private void saveTextAsFile(String filename, String content){
        String fileName = filename + ".csv";

        //Create file
        File file = new File("/storage/emulated/0/Download/","TestCamiones");

        if(!file.exists()){
            file.mkdirs();
        }
        File txtFile = new File(file.getAbsolutePath(),fileName);

        //Write file
        try {
            FileOutputStream fos  = new FileOutputStream(txtFile);
            fos.write(content.getBytes());
            fos.close();
            Toast.makeText(getActivity(), "Saved!", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(getActivity(), "Not Saved! FileNotException", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(getActivity(), "Not Saved! IOException", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }



}
