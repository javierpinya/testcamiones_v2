package com.javierpinya.testcamiones_v2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;

import com.javierpinya.testcamiones_v2.Clases.UsuarioEntity;

public class NuevoUsuarioDialogFragment extends DialogFragment {

    private NuevoUsuarioDialogViewModel mViewModel;
    private View view;
    private EditText etusuario;
    private EditText etpassword;

    public static NuevoUsuarioDialogFragment newInstance() {
        return new NuevoUsuarioDialogFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nuevo_usuario_dialog_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NuevoUsuarioDialogViewModel.class);
        // TODO: Use the ViewModel
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Nuevo usuario");
        builder.setMessage("Introduzca los datos del nuevo usuario")
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String usuario = etusuario.getText().toString();
                        String pass = etpassword.getText().toString();

                        NuevoUsuarioDialogViewModel viewModel = ViewModelProviders.of(getActivity()).get(NuevoUsuarioDialogViewModel.class);
                        viewModel.insertarUsuario(new UsuarioEntity(usuario, pass));
                        dialog.dismiss();

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.nuevo_usuario_dialog_fragment, null);
        etusuario = view.findViewById(R.id.etnuevousuario);
        etpassword = view.findViewById(R.id.etnuevopass);

        builder.setView(view);

        return builder.create();
    }
}
