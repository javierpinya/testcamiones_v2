package com.javierpinya.testcamiones_v2.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.javierpinya.testcamiones_v2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SincronizarFragment extends Fragment {


    public SincronizarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sincronizar, container, false);

        return view;
    }

}
