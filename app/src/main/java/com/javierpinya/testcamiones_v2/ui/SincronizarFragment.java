package com.javierpinya.testcamiones_v2.ui;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.javierpinya.testcamiones_v2.Clases.TaccamiEntity;
import com.javierpinya.testcamiones_v2.Clases.TaccatrEntity;
import com.javierpinya.testcamiones_v2.Clases.TacprcoEntity;
import com.javierpinya.testcamiones_v2.Clases.TacsecoEntity;
import com.javierpinya.testcamiones_v2.Clases.UsuarioEntity;
import com.javierpinya.testcamiones_v2.NuevoUsuarioDialogViewModel;
import com.javierpinya.testcamiones_v2.R;
import com.javierpinya.testcamiones_v2.TaccamiViewModel;
import com.javierpinya.testcamiones_v2.TaccatrViewModel;
import com.javierpinya.testcamiones_v2.TaccondViewModel;
import com.javierpinya.testcamiones_v2.TacprcoViewModel;
import com.javierpinya.testcamiones_v2.TacsecoViewModel;
import com.javierpinya.testcamiones_v2.TplcprtViewModel;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SincronizarFragment extends Fragment {

    private static final int READ_REQUEST_CODE = 1000;
    private String matricula_archivo="";
    private Button btnSincronizar;
    private Button btnLeerBD;
    private Button btnGuardarVehiculo;
    private EditText etTexto;
    private TacprcoViewModel tacprcoViewModel;
    private TacsecoViewModel tacsecoViewModel;
    private TaccamiViewModel taccamiViewModel;
    private TaccatrViewModel taccatrViewModel;
    private TaccondViewModel taccondViewModel;
    private TplcprtViewModel tplcprtViewModel;
    private TaccamiEntity taccamiEntity;
    private TaccatrEntity taccatrEntity;
    private NuevoUsuarioDialogViewModel mViewModel;
    private List<TacprcoEntity> tractoras = new ArrayList<>();
    private List<UsuarioEntity> usuarios = new ArrayList<>();
    private List<String> matricula = new ArrayList<>();
    private List<Integer> tara = new ArrayList<>();
    private final String filename = "prueba_testcamiones2";
    private final List<String> contentTacprco = new ArrayList<>();
    private final List<String> contentTacseco = new ArrayList<>();
    private final List<String> contentTaccami = new ArrayList<>();
    private final String path = "/storage/emulated/0/Download/TestCamiones/";
    private TacprcoEntity tacprcoEntity;
    private Date date = new Date();
    private final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    private SimpleDateFormat parseador = new SimpleDateFormat("dd/MM/yyyy");
    private int taccamiSize;
    private List<Integer> taccamiIds = new ArrayList<>();
    private List<Integer> tacprcoids = new ArrayList<>();
    private List<String> tacprcoMat = new ArrayList<>();
    private List<Integer> tacsecoids = new ArrayList<>();
    private List<String> tacsecoMat = new ArrayList<>();
    private int tacprcoid;
    private int tacsecoid;
    private int taccamiid;
    private List<String> contentTaccatr = new ArrayList<>();


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
        btnGuardarVehiculo = view.findViewById(R.id.btnGuardarVehiculo);
        etTexto = view.findViewById(R.id.etHelpSync);
        lanzarViewModel();



        final NuevoUsuarioDialogViewModel mViewModel = ViewModelProviders.of(getActivity()).get(NuevoUsuarioDialogViewModel.class);
        //mViewModel.insertarUsuario(new UsuarioEntity("juan", "juan"));

        for (int i=0;i<100;i++){
            try {
                contentTacprco.add("E000" + i + "AAA,20/10/2020,20/10/2020,7210" + i + ",21000,90000" + i + ",T,20/10/2060,E,0,N,N" + "\n");
                contentTacseco.add("E000" + i + "BBB,20/10/2020,20/10/2020,5210" + i + ",18000,80000" + i + ",R,20/10/2060,3,0,20/10/2060,E,N,N,N" + "\n");
                contentTaccami.add(i + ",E000" + i + "AAA,E000" + i + "BBB,18000,40000,20/10/2020\n");
                contentTaccatr.add(i + ",0010,23" + i + ",20/10/2020\n");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        saveTextAsFile("Tacprco", contentTacprco);
        saveTextAsFile("Tacseco", contentTacseco);
        saveTextAsFile("Taccami", contentTaccami);
        saveTextAsFile("Taccatr", contentTaccatr);


        btnSincronizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                tacprcoViewModel.deleteAllTacprco();
                tacsecoViewModel.deleteAllTacseco();
                //taccamiViewModel.deleteAllTaccami();
                taccatrViewModel.deleteAllTaccatr();

                leerTacprco("Tacprco.csv");
                leerTacseco("Tacseco.csv");
                taccamiViewModel.findAllVehiculos().observe(getActivity(), new Observer<List<TaccamiEntity>>() {
                    @Override
                    public void onChanged(List<TaccamiEntity> taccamiEntities) {
                        Toast.makeText(getActivity(), String.valueOf(taccamiEntities.size()), Toast.LENGTH_SHORT).show();
                    }
                });

                //leerTaccatr("Taccatr.csv");

                /*
                //Creamos los datos
                for (int i = 0; i < 10; i++) {
                    try {
                        tacprcoViewModel.insertTacprco(new TacprcoEntity("E000" + i + "AAA", parseador.parse("20/10/2020"), parseador.parse("20/10/2020"), 7210 + i, 21000, 90000 + i, "T", parseador.parse("20/10/2060"), "E", false, false, false));
                        tacsecoViewModel.insertTacseco(new TacsecoEntity("E000" + i + "BBB", parseador.parse("20/10/2020"), parseador.parse("20/10/2020"), 521 + i, 18000, 80000 + i, "R", parseador.parse("20/10/2060"), 3, false, parseador.parse("20/10/2060"), "E", false, false, false));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                 */
            }
        });

        btnGuardarVehiculo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                leerTaccami("Taccami.csv");
                //completarTaccami("Taccami.csv");
                /* taccamiViewModel.findTaccamiByCodVehiculo(2).observe(getActivity(), new Observer<List<TaccamiEntity>>() {
                    @Override
                    public void onChanged(List<TaccamiEntity> taccamiEntities) {
                        Log.d("TACCAMI: ", String.valueOf(taccamiEntities.get(0).getCod_vehiculo()));
                    }
                });
        */

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
                            Log.d("TACPRCO: ", tacprcoEntities.get(i).getMatricula() + " " + tacprcoEntities.get(i).getTara() + " " + tacprcoEntities.get(i).getChip() + " " + df.format(tacprcoEntities.get(i).getFec_cadu_adr()));
                        }
                    }
                });

                tacsecoViewModel.getAllTacseco().observe(getActivity(), new Observer<List<TacsecoEntity>>() {
                    @Override
                    public void onChanged(List<TacsecoEntity> tacsecoEntities) {
                        for (int i=0;i<tacsecoEntities.size();i++){
                            Log.d("TACSECO: ", tacsecoEntities.get(i).getMatricula() + " " + tacsecoEntities.get(i).getTara() + " " + tacsecoEntities.get(i).getChip() + " " + df.format(tacsecoEntities.get(i).getFec_cadu_adr()));
                        }
                    }
                });

                taccamiViewModel.findAllVehiculos().observe(getActivity(), new Observer<List<TaccamiEntity>>() {
                    @Override
                    public void onChanged(List<TaccamiEntity> taccamiEntities) {
                        for (int i=0;i<taccamiEntities.size();i++){
                            Log.d("TACCAMI: ", taccamiEntities.get(i).getCod_vehiculo() + " - CisternaID: " + taccamiEntities.get(i).getCisternaId() + " - TractoraId: " + taccamiEntities.get(i).getTractoraId());
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
        tacsecoViewModel = ViewModelProviders.of(getActivity()).get(TacsecoViewModel.class);
        taccamiViewModel = ViewModelProviders.of(getActivity()).get(TaccamiViewModel.class);
        taccatrViewModel = ViewModelProviders.of(getActivity()).get(TaccatrViewModel.class);
        taccondViewModel = ViewModelProviders.of(getActivity()).get(TaccondViewModel.class);
        tplcprtViewModel = ViewModelProviders.of(getActivity()).get(TplcprtViewModel.class);
    }

    // Read contentTacprco of the file
    private void leerTacprco(String filename){
        boolean gas = false;
        boolean blo = false;
        boolean que = false;

        File file = new File(getActivity().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), filename);

        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {

                if(nextLine[9] == "N" || nextLine[9] == "0"){
                    gas = false;
                }else{
                    gas = true;
                }

                if(nextLine[10] == "N" || nextLine[10] == "0"){
                    blo = false;
                }else{
                    blo = true;
                }

                if(nextLine[11] == "N" || nextLine[11] == "0"){
                    que = false;
                }else{
                    que = true;
                }

                try {
                    tacprcoViewModel.insertTacprco(new TacprcoEntity(nextLine[0], parseador.parse(nextLine[1]), parseador.parse(nextLine[2]),Integer.valueOf(nextLine[3]),Integer.valueOf(nextLine[4]),Integer.valueOf(nextLine[5]), nextLine[6], parseador.parse(nextLine[7]), nextLine[8], gas, blo, que));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void leerTacseco(String filename){
        boolean pes = false;
        boolean gas = false;
        boolean blo = false;
        boolean que = false;

        File file = new File(getActivity().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), filename);

        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {

                if (nextLine[9] == "N" || nextLine[9] == "0" || nextLine[9] == "") {
                    pes = false;
                } else {
                    pes = true;
                }

                if (nextLine[12] == "N" || nextLine[12] == "0" || nextLine[12] == "") {
                    gas = false;
                } else {
                    gas = true;
                }

                if (nextLine[13] == "N" || nextLine[13] == "0" || nextLine[13] == "") {
                    blo = false;
                } else {
                    blo = true;
                }

                if (nextLine[14] == "N" || nextLine[14] == "0" || nextLine[14] == "")
                    que = false;
                else{
                    que = true;
                }
                try {
                    tacsecoViewModel.insertTacseco(new TacsecoEntity(nextLine[0], parseador.parse(nextLine[1]), parseador.parse(nextLine[2]), Integer.valueOf(nextLine[3]), Integer.valueOf(nextLine[4]), Integer.valueOf(nextLine[5]), nextLine[6], parseador.parse(nextLine[7]), Integer.valueOf(nextLine[8]), pes, parseador.parse(nextLine[10]), nextLine[11], gas, blo, que));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void leerTaccami(String filename) {


        File file = new File(getActivity().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), filename);

        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                Log.d("nextline[0]:" , nextLine[0]);
                Log.d("nextline[1]:" , nextLine[1]);
                Log.d("nextline[2]:" , nextLine[2]);
                Log.d("nextline[3]:" , nextLine[3]);
                Log.d("nextline[4]:" , nextLine[4]);
                Log.d("nextline[5]:" , nextLine[5]);
                tacprcoViewModel.findTacprcoByMatricula(nextLine[1]).observe(getActivity(), new Observer<List<TacprcoEntity>>() {
                    @Override
                    public void onChanged(List<TacprcoEntity> tacprcoEntities) {
                        tacprcoid = tacprcoEntities.get(0).getId();
                    }
                });
                tacsecoViewModel.findTacsecoByMatricula(nextLine[2]).observe(getActivity(), new Observer<List<TacsecoEntity>>() {
                    @Override
                    public void onChanged(List<TacsecoEntity> tacsecoEntities) {
                        tacsecoid = tacsecoEntities.get(0).getId();
                    }
                });
                try {
                    taccamiEntity = new TaccamiEntity();
                    taccamiEntity.setCod_vehiculo(Integer.valueOf(nextLine[0]));
                    taccamiEntity.setTractoraId(2);
                    taccamiEntity.setCisternaId(2);
                    taccamiEntity.setTara(Integer.valueOf(nextLine[3]));
                    taccamiEntity.setPesoMaximo(Integer.valueOf(nextLine[4]));
                    taccamiEntity.setFec_baja((parseador.parse(nextLine[5])));
                    taccamiViewModel.insertarVehiculo(taccamiEntity);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void completarTaccami(String filename){
        File file = new File(getActivity().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), filename);
        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {

                taccamiViewModel.findTaccamiByCodVehiculo(Integer.valueOf(nextLine[0])).observe(getActivity(), new Observer<List<TaccamiEntity>>() {
                    @Override
                    public void onChanged(List<TaccamiEntity> taccamiEntities) {
                        taccamiid = taccamiEntities.get(0).getId();
                        Log.d("taccami size", String.valueOf(taccamiEntities.size()));
                    }
                });


                tacprcoViewModel.findTacprcoByMatricula(nextLine[1]).observe(getActivity(), new Observer<List<TacprcoEntity>>() {
                    @Override
                    public void onChanged(List<TacprcoEntity> tacprcoEntities) {
                        tacprcoid = tacprcoEntities.get(0).getId();
                    }
                });
                tacsecoViewModel.findTacsecoByMatricula(nextLine[2]).observe(getActivity(), new Observer<List<TacsecoEntity>>() {
                    @Override
                    public void onChanged(List<TacsecoEntity> tacsecoEntities) {
                        tacsecoid = tacsecoEntities.get(0).getId();
                    }
                });
                /*
                taccamiEntity = new TaccamiEntity();
                taccamiEntity.setId(taccamiid);
                taccamiEntity.setTractoraId(tacprcoid);
                taccamiEntity.setCisternaId(tacsecoid);
                taccamiViewModel.updateVehiculo(taccamiEntity);

                 */
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void leerTaccatr(String filename){
        File file = new File(getActivity().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), filename);
        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                try {
                    taccatrViewModel.insertTaccatr(new TaccatrEntity(nextLine[1], nextLine[2], parseador.parse(nextLine[3])));
                    taccamiViewModel.findTaccamiByCodVehiculo(Integer.valueOf(nextLine[0])).observe(getActivity(), new Observer<List<TaccamiEntity>>() {
                        @Override
                        public void onChanged(List<TaccamiEntity> taccamiEntities) {
                            taccamiid = taccamiEntities.get(0).getId();
                        }
                    });
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                /*
                taccatrEntity = new TaccatrEntity();
                taccatrEntity.setId(taccamiid);
                taccatrEntity.setVehiculoId(taccamiid);
                taccatrViewModel.updateTaccatr(taccatrEntity);

                 */
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

        //Write file
        try {
            FileOutputStream fos  = new FileOutputStream(file);
            for (int i=0;i<content.size();i++) {
                fos.write(content.get(i).getBytes());
            }
            fos.close();
            Toast.makeText(getActivity(), "Saved! - contentSize: " + content.size(), Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(getActivity(), "Not Saved! FileNotException", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(getActivity(), "Not Saved! IOException", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }
}
