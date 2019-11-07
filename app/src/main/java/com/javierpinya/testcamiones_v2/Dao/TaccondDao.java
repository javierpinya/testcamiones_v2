package com.javierpinya.testcamiones_v2.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.javierpinya.testcamiones_v2.Clases.TaccondEntity;

import java.util.List;

@Dao
public interface TaccondDao {

    @Insert
    void insertTaccond(TaccondEntity taccond);

    @Update
    void updateTaccond(TaccondEntity taccond);

    @Delete
    void deleteTaccondById(TaccondEntity taccond);

    @Query("SELECT * FROM taccond")
    LiveData<List<TaccondEntity>> findAllTaccond();

    @Query("SELECT * FROM taccond WHERE conductor LIKE :conductor")
    LiveData<List<TaccondEntity>> findTaccondByConductor(String conductor);

    @Query("SELECT * FROM taccond WHERE dni LIKE :dni")
    LiveData<List<TaccondEntity>> findTaccondByDni(String dni);

    @Query("SELECT * FROM taccond WHERE apellidos LIKE :apellidos")
    LiveData<List<TaccondEntity>> findTaccondByApellidos(String apellidos);

    @Query("SELECT * FROM taccond WHERE nombre LIKE :nombre")
    LiveData<List<TaccondEntity>> findTaccondByNombre(String nombre);

    @Query("SELECT * FROM taccond WHERE id LIKE :id")
    TaccondEntity findTaccondById(int id);

    @Query("DELETE FROM taccond")
    void deleteAllTaccond();

}
