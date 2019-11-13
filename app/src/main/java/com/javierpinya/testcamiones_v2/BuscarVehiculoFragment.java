package com.javierpinya.testcamiones_v2;


import android.os.Bundle;
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

import com.javierpinya.testcamiones_v2.Clases.TaccamiEntity;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuscarVehiculoFragment extends Fragment {
    private EditText primerComp;
    private EditText segundoComp;
    private Button buscar;
    private String primer="";
    private String segundo = "";
    private TacprcoViewModel tacprcoViewModel;
    private TacsecoViewModel tacsecoViewModel;
    private TaccamiViewModel taccamiViewModel;
    private TaccatrViewModel taccatrViewModel;
    private TaccondViewModel taccondViewModel;
    private TplcprtViewModel tplcprtViewModel;


    public BuscarVehiculoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buscar_vehiculo, container, false);
        primerComp = view.findViewById(R.id.etPrimerComp);
        segundoComp = view.findViewById(R.id.etSegundoComp);
        buscar = view.findViewById(R.id.btnBuscarVehiculo);
        lanzarViewModel();

        buscar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                primer = primerComp.getText().toString();
                segundo = segundoComp.getText().toString();
                if (primer.isEmpty() && segundo.isEmpty()){
                    Toast.makeText(getActivity(), "Introduzca una matrícula", Toast.LENGTH_SHORT).show();
                }else{
                    //Buscar con el modelView
                    buscarComponentes(primer, segundo);
                }
            }
        });

        return view;
    }

    private void buscarComponentes(String primer, String segundo) {
        final List<Integer> cod_vehiculo1 = new ArrayList<>();
        final List<Integer> cod_vehiculo2 = new ArrayList<>();
        final List<Integer> listaEquivalente = new ArrayList<>();
        final List<Integer> tractoras = new ArrayList<>();
        final List<Integer> cisternas = new ArrayList<>();

        if (primer.length()>0) {
            taccamiViewModel.findTaccamiByTMatricula(primer).observe(getActivity(), new Observer<List<TaccamiEntity>>() {
                @Override
                public void onChanged(List<TaccamiEntity> taccamiEntities) {
                    for (int i = 0; i < taccamiEntities.size(); i++) {
                        cod_vehiculo1.add(taccamiEntities.get(i).getCod_vehiculo());
                    }
                }
            });
        }
        if(segundo.length()>0){
            taccamiViewModel.findTaccamiByCMatricula(segundo).observe(getActivity(), new Observer<List<TaccamiEntity>>() {
                @Override
                public void onChanged(List<TaccamiEntity> taccamiEntities) {
                    for(int i=0;i<taccamiEntities.size();i++) {
                        cod_vehiculo2.add(taccamiEntities.get(i).getCod_vehiculo());
                    }
                }
            });
        }

        if(cod_vehiculo1.size()>0 && cod_vehiculo2.size()>0){
            for(int i=0;i<cod_vehiculo1.size();i++){
                for(int j=0;j<cod_vehiculo2.size();j++){
                    if (cod_vehiculo1.get(i) == cod_vehiculo2.get(j)){
                        listaEquivalente.add(cod_vehiculo1.get(i));
                    }
                }
            }
        }else{
            for(int i=0;i<cod_vehiculo1.size();i++){
                listaEquivalente.add(cod_vehiculo1.get(i));
            }
            for(int i=0;i<cod_vehiculo2.size();i++){
                listaEquivalente.add(cod_vehiculo2.get(i));
            }
        }

        for(int i=0;i<listaEquivalente.size();i++) {
            taccamiViewModel.findTaccamiByCodVehiculo(listaEquivalente.get(i)).observe(getActivity(), new Observer<List<TaccamiEntity>>() {
                @Override
                public void onChanged(List<TaccamiEntity> taccamiEntities) {
                    tractoras.add(taccamiEntities.get(0).getTractoraId());
                    cisternas.add(taccamiEntities.get(0).getCisternaId());
                }
            });
        }




    }

    private void lanzarViewModel() {
        tacprcoViewModel = ViewModelProviders.of(getActivity()).get(TacprcoViewModel.class);
        tacsecoViewModel = ViewModelProviders.of(getActivity()).get(TacsecoViewModel.class);
        taccamiViewModel = ViewModelProviders.of(getActivity()).get(TaccamiViewModel.class);
        taccatrViewModel = ViewModelProviders.of(getActivity()).get(TaccatrViewModel.class);
        taccondViewModel = ViewModelProviders.of(getActivity()).get(TaccondViewModel.class);
        tplcprtViewModel = ViewModelProviders.of(getActivity()).get(TplcprtViewModel.class);
    }

}
