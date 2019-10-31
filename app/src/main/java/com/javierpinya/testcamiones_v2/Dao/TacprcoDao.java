package com.javierpinya.testcamiones_v2.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.javierpinya.testcamiones_v2.Clases.TacprcoEntity;

import java.util.List;

@Dao
public interface TacprcoDao {

    @Insert
    void insertTacprco(TacprcoEntity tacprco);

    @Update
    void updateTacprcoById(TacprcoEntity tacprco);

    @Delete
    void deleteTacprcoById(TacprcoEntity tacprco);

    @Query("SELECT * FROM tacprco WHERE matricula LIKE :matricula")
    LiveData<List<TacprcoEntity>> findTacprcoByMatricula(String matricula);

    @Query("SELECT * FROM tacprco")
    LiveData<List<TacprcoEntity>> getAllTacprco();

    @Query("SELECT * FROM tacprco WHERE id LIKE :id")
    TacprcoEntity findTacprcoById(int id);

    @Query("DELETE FROM tacprco")
    void deleteAllTacprco();


}
