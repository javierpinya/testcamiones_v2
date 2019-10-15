package com.javierpinya.testcamiones_v2.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.javierpinya.testcamiones_v2.Clases.InspeccionEntity;

import java.util.List;

@Dao
public interface InspeccionDao {

    @Insert
    void insert(InspeccionEntity inspeccion);

    @Update
    void updateInspeccionById(InspeccionEntity inspeccion);

    @Delete
    void deleteInspeccionById(InspeccionEntity inspeccion);

    @Query("select * from inspeccion")
    LiveData<List<InspeccionEntity>> findAllInspecciones();

    @Query("select * from inspeccion where inspeccion like :inspeccion")
    InspeccionEntity findInspeccionByInspeccion(String inspeccion);

    @Query("select id from inspeccion where inspeccion like :inspeccion")
    int findIdInspeccionByInspeccion(String inspeccion);

    @Query("select * from inspeccion where inspector like :inspector")
    LiveData<List<InspeccionEntity>> findInspeccionByInspector(String inspector);

    @Query("select * from inspeccion where instalacion like :instalacion")
    LiveData<List<InspeccionEntity>> findInspeccionByInstalacion(String instalacion);

    @Query("select * from inspeccion where transportistaId in (select id from taccatr where transportista like :transportista)")
    LiveData<List<InspeccionEntity>> findInspeccionByTransportista(String transportista);

    @Query("select * from inspeccion where tractoraId in (select id from tacprco where matricula like :matricula)")
    LiveData<List<InspeccionEntity>> findInspeccionByTractora(String matricula);

    @Query("select * from inspeccion where cisternaId in (select id from tacseco where matricula like :matricula)")
    LiveData<List<InspeccionEntity>> findInspeccionByCisterna(String matricula);

    @Query("select * from inspeccion where conductorId in (select id from taccond where conductor like :conductor)")
    LiveData<List<InspeccionEntity>> findInspeccionByConductor(String conductor);

}
