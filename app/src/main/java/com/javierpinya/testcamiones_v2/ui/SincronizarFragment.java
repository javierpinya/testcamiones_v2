package com.javierpinya.testcamiones_v2.ui;


import android.app.Activity;
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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.javierpinya.testcamiones_v2.Clases.TacprcoEntity;
import com.javierpinya.testcamiones_v2.Clases.UsuarioEntity;
import com.javierpinya.testcamiones_v2.NuevoUsuarioDialogViewModel;
import com.javierpinya.testcamiones_v2.R;
import com.javierpinya.testcamiones_v2.TacprcoViewModel;
import com.opencsv.CSVReader;

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
    private final String filename = "prueba_testcamiones2";
    private final List<String> content = new ArrayList<>();
    private final String path = "/storage/emulated/0/Download/TestCamiones/";
    private TacprcoEntity tacprcoEntity;


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

        final NuevoUsuarioDialogViewModel mViewModel = ViewModelProviders.of(getActivity()).get(NuevoUsuarioDialogViewModel.class);
        mViewModel.insertarUsuario(new UsuarioEntity("juan", "juan"));

        for (int i=0;i<10;i++){
            content.add("E24" + i + "4JNZ,1800" + i + ",2400" + i + "\n");
        }
        saveTextAsFile(filename,content);


        btnSincronizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lanzarViewModel();
                tacprcoViewModel.deleteAllTacprco();
                leerArchivo();


                //
               // NuevoUsuarioDialogViewModel mViewModel = ViewModelProviders.of(getActivity()).get(NuevoUsuarioDialogViewModel.class);
               // mViewModel.insertarUsuario(new UsuarioEntity("juan", "juan"));

               // TacprcoViewModel tacprcoViewModel = ViewModelProviders.of(getActivity()).get(TacprcoViewModel.class);
               // tacprcoViewModel.insertTacprco(new TacprcoEntity("E2474JNZ", 5210, 18000,121212,"T","E"));
                //tacprcoViewModel.insertTacprco(new TacprcoEntity("E2400AAA", 5310, 18000,121213,"T","E"));
                //tacprcoViewModel.insertTacprco(new TacprcoEntity("E2401BBB", 5410, 18000,121214,"T","E"));

                //performFileSearch();

            }
        });

        btnLeerBD.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String cadena="";
                List resultado = new ArrayList();

                tacprcoViewModel.getAllTacprco().observe(getActivity(), new Observer<List<TacprcoEntity>>() {
                    @Override
                    public void onChanged(List<TacprcoEntity> tacprcoEntities) {
                        for (int i=0;i<tacprcoEntities.size();i++){
                            Log.d("TACPRCO: ", tacprcoEntities.get(i).getMatricula() + " " + tacprcoEntities.get(i).getTara() + " " + tacprcoEntities.get(i).getChip());
                        }
                    }
                });

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
    }

    // Read content of the file
    private void leerArchivo(){

        File file = new File(getActivity().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), filename + ".csv");
        //TacprcoViewModel tacprcoViewModel = ViewModelProviders.of(getActivity()).get(TacprcoViewModel.class);


        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                tacprcoViewModel.insertTacprco(new TacprcoEntity(nextLine[0], Integer.valueOf(nextLine[1]), Integer.valueOf(nextLine[2]),121212,"T","E"));
                //Log.e("Datossssss: ", "" + nextLine[0] + " - " + nextLine[1] + " - " + nextLine[2]);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

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

    private void saveTextAsFile(String filename, List<String> content){
        String fileName = filename + ".csv";
        File file;
        file = new File(getActivity().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), fileName);

       /*
        //Create file
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            file = new File(getActivity().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), fileName);

        }else {
            //file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);
            file = new File(getActivity().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), fileName);
        }

        */

        //Write file
        try {
            FileOutputStream fos  = new FileOutputStream(file);
            for (int i=0;i<content.size();i++) {
                fos.write(content.get(i).getBytes());
            }
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
