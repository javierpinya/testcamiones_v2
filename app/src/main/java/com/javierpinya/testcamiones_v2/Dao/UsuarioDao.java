package com.javierpinya.testcamiones_v2.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.javierpinya.testcamiones_v2.Clases.UsuarioEntity;

import java.util.List;

@Dao
public interface UsuarioDao {

    @Query("select * from credenciales")
    LiveData<List<UsuarioEntity>> getCredenciales();

    @Insert
    void insert(UsuarioEntity usuario);
}
