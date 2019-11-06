package com.javierpinya.testcamiones_v2.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.javierpinya.testcamiones_v2.Clases.TacsecoEntity;

import java.util.List;

@Dao
public interface TacsecoDao {

    @Insert
    void insertTacseco(TacsecoEntity tacseco);

    @Update
    void updateTacsecoById(TacsecoEntity tacseco);

    @Delete
    void deleteTacsecoById(TacsecoEntity tacseco);

    @Query("SELECT * FROM tacseco WHERE matricula LIKE :matricula")
    LiveData<List<TacsecoEntity>> findTacsecoByMatricula(String matricula);

    @Query("SELECT * FROM tacseco WHERE id LIKE :id")
    TacsecoEntity findTacsecoById(int id);

    @Query("SELECT * FROM tacseco")
    LiveData<List<TacsecoEntity>> getAllTacseco();

    @Query("DELETE FROM tacseco")
    void deleteAllTacseco();
}
