package com.javierpinya.testcamiones_v2;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.javierpinya.testcamiones_v2.Clases.UsuarioEntity;
import com.javierpinya.testcamiones_v2.Repositories.UsuarioRepository;

import java.util.List;

public class NuevoUsuarioDialogViewModel extends AndroidViewModel {

    private List<UsuarioEntity> allUsuarios;
    private UsuarioRepository usuarioRepository;

    public NuevoUsuarioDialogViewModel(Application application){
        super(application);

        usuarioRepository = new UsuarioRepository(application);
    }

    public LiveData<List<UsuarioEntity>> getAllUsuarios(){
        return usuarioRepository.encuentraUsuarios();
    }

    public void insertarUsuario(UsuarioEntity usuarioEntity){
        usuarioRepository.insert(usuarioEntity);
    }

}
