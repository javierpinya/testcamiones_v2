package com.javierpinya.testcamiones_v2.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.javierpinya.testcamiones_v2.Clases.TplcprtEntity;

import java.util.List;

@Dao
public interface TplcprtDao {
    @Insert
    void insertTplcprt(TplcprtEntity tplcprt);

    @Update
    void updateTplcprtById(TplcprtEntity tplcprt);

    @Delete
    void deleteTplcprtById(TplcprtEntity tplcprt);

    @Query("SELECT * FROM tplcprt WHERE cisternaId LIKE :cisterna")
    LiveData<List<TplcprtEntity>> findTplcprtById(int cisterna);

    @Query("SELECT * FROM tplcprt WHERE cod_tag_cprt LIKE :tag")
    LiveData<List<TplcprtEntity>> findTplcprtByTag(int tag);

    @Query("DELETE FROM tplcprt")
    void deleteAllTplcprt();
}
