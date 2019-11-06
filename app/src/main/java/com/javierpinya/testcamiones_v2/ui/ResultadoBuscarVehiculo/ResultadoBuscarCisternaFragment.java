package com.javierpinya.testcamiones_v2.ui.ResultadoBuscarVehiculo;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.javierpinya.testcamiones_v2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultadoBuscarCisternaFragment extends Fragment {


    public ResultadoBuscarCisternaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resultado_buscar_cisterna, container, false);
    }

}
