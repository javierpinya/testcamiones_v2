package com.javierpinya.testcamiones_v2;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.javierpinya.testcamiones_v2.Clases.UsuarioEntity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private EditText usuario;
    private EditText password;
    private Button btnAddUser;
    private Button btnLogin;
    private String user;
    private String pass;
    private NuevoUsuarioDialogViewModel nuevoUsuarioDialogViewModel;

    private List<UsuarioEntity> allUsuarios;
    private boolean login = false;

    public static LoginFragment newInstance(){
        return new LoginFragment();
    }


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        allUsuarios = new ArrayList<>();

        usuario = view.findViewById(R.id.etusuario);
        password = view.findViewById(R.id.etpass);
        btnLogin = view.findViewById(R.id.btnlogin);
        btnAddUser = view.findViewById(R.id.btnAddUser);
        lanzarViewModel();
        //final Intent intent = new Intent();

        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                user = usuario.getText().toString();
                pass = password.getText().toString();


                if (allUsuarios.size()>0) {
                    for (int i=0;i<allUsuarios.size();i++){
                        if (user.trim().equals(allUsuarios.get(i).usuario.trim())) {
                            if (pass.trim().equals(allUsuarios.get(i).password.trim())) {
                                Intent intent = new Intent();
                                intent.setClass(getContext(), MenuActivity.class);
                                startActivity(intent);
                            }else{
                                login = false;
                                //allUsuarios.clear();
                                Toast.makeText(getActivity(), "Password incorrecto", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            login = false;
                            //allUsuarios.clear();
                        }
                    }

                }
            }
        });

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lanzarDialogBuilder();

            }
        });

        return view;
    }

    private void lanzarViewModel(){
        nuevoUsuarioDialogViewModel = ViewModelProviders.of(getActivity()).get(NuevoUsuarioDialogViewModel.class);
        nuevoUsuarioDialogViewModel.getAllUsuarios().observe(getActivity(), new Observer<List<UsuarioEntity>>() {
            @Override
            public void onChanged(List<UsuarioEntity> usuarioEntities) {
                allUsuarios = usuarioEntities;
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.usuarios, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_user:
                lanzarDialogBuilder();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void lanzarDialogBuilder() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        NuevoUsuarioDialogFragment dialogNuevoUsuario = new NuevoUsuarioDialogFragment();
        dialogNuevoUsuario.show(fm, "NuevoUsuarioDialogFragment");
    }




}
