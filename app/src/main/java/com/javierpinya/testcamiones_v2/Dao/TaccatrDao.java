package com.javierpinya.testcamiones_v2.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.javierpinya.testcamiones_v2.Clases.TaccatrEntity;

import java.util.List;

@Dao
public interface TaccatrDao {

    @Insert
    void insertTaccatr(TaccatrEntity taccatr);

    @Update
    void updateTaccatrById(TaccatrEntity taccatr);

    @Delete
    void deleteTaccatrById(TaccatrEntity taccatr);

    @Query("DELETE FROM taccatr")
    void deleteAllTaccatr();

    @Query("SELECT * FROM taccatr WHERE id LIKE :id")
    TaccatrEntity findTaccatrById(int id);

    @Query("SELECT * FROM taccatr WHERE transportista LIKE :transportista AND slo LIKE :slo")
    LiveData<List<TaccatrEntity>> findTaccatrByTransSlo(String transportista, String slo);

    @Query("SELECT * FROM taccatr WHERE transportista LIKE :transportista")
    LiveData<List<TaccatrEntity>> findTaccatrByTrans(String transportista);


}
