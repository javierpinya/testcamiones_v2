package com.javierpinya.testcamiones_v2.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.javierpinya.testcamiones_v2.Clases.TaccamiEntity;

import java.util.List;

@Dao
public interface TaccamiDao {

    @Insert
    void insert(TaccamiEntity vehiculo);

    @Update
    void updateTaccamiById(TaccamiEntity taccami);

    @Delete
    void deleteTaccamiById(TaccamiEntity taccami);

    @Query("select * from taccami")
    LiveData<List<TaccamiEntity>> findAllTaccami();

    @Query("select * from taccami where cod_vehiculo LIKE :cod_vehiculo")
    LiveData<List<TaccamiEntity>> findTaccamiByCodVehiculo(int cod_vehiculo);

    @Query("SELECT * FROM taccami WHERE tractoraId in (SELECT id FROM tacprco where matricula LIKE :matricula)")
    LiveData<List<TaccamiEntity>> findTaccamiByTMatricula(String matricula);

    @Query("SELECT * FROM taccami WHERE cisternaId in (SELECT id FROM tacseco where matricula LIKE :matricula)")
    LiveData<List<TaccamiEntity>> findTaccamiByCMatricula(String matricula);

    @Query("DELETE FROM taccami")
    void deleteAllTaccami();
}
