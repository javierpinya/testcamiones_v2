package com.javierpinya.testcamiones_v2.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.javierpinya.testcamiones_v2.AppDatabase;
import com.javierpinya.testcamiones_v2.Clases.InspeccionEntity;
import com.javierpinya.testcamiones_v2.Dao.InspeccionDao;

import java.util.List;

public class InspeccionRepository {

    private InspeccionDao inspeccionDao;

    public InspeccionRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        inspeccionDao = db.inspeccionDao();
    }

    public LiveData<List<InspeccionEntity>> getAllInspecciones(){
        return inspeccionDao.findAllInspecciones();
    }

    public InspeccionEntity findInspeccionByInspeccion(String inspeccion){
        return inspeccionDao.findInspeccionByInspeccion(inspeccion);
    }

    public int findIdInspeccionByInspeccion(String inspeccion){
        return inspeccionDao.findIdInspeccionByInspeccion(inspeccion);
    }

    public LiveData<List<InspeccionEntity>> findInspeccionByInspector(String inspector){
        return inspeccionDao.findInspeccionByInspector(inspector);
    }

    public LiveData<List<InspeccionEntity>> findInspeccionByInstalacion(String instalacion){
        return inspeccionDao.findInspeccionByInstalacion(instalacion);
    }

    public LiveData<List<InspeccionEntity>> findInspeccionByTransportista(String transportista){
        return inspeccionDao.findInspeccionByTransportista(transportista);
    }

    public LiveData<List<InspeccionEntity>> findInspeccionByTractora(String tractora){
        return inspeccionDao.findInspeccionByTractora(tractora);
    }

    public LiveData<List<InspeccionEntity>> findInspeccionByCisterna(String cisterna){
        return inspeccionDao.findInspeccionByCisterna(cisterna);
    }

    public LiveData<List<InspeccionEntity>> findInspeccionByConductor(String conductor){
        return inspeccionDao.findInspeccionByConductor(conductor);
    }

    public void insert (InspeccionEntity inspeccionEntity){
        new insertAsyncTask(inspeccionDao).execute(inspeccionEntity);
    }

    private static class insertAsyncTask extends AsyncTask<InspeccionEntity, Void, Void>{

        private InspeccionDao asyncTaskDao;

        insertAsyncTask(InspeccionDao dao){
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(InspeccionEntity... inspeccionEntities) {
            asyncTaskDao.insert(inspeccionEntities[0]);
            return null;
        }
    }

    public void deleteInspeccionById(InspeccionEntity inspeccionEntity){
        new deleteAsyncTask(inspeccionDao).execute(inspeccionEntity);
    }

    private static class deleteAsyncTask extends AsyncTask<InspeccionEntity, Void, Void>{

        private InspeccionDao asyncTaskDao;

        deleteAsyncTask(InspeccionDao dao){
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(InspeccionEntity... inspeccionEntities) {
            asyncTaskDao.deleteInspeccionById(inspeccionEntities[0]);
            return null;
        }
    }

    public void updateInspeccionById(InspeccionEntity inspeccionEntity){
        new updateAsyncTask(inspeccionDao).execute(inspeccionEntity);
    }

    private static class updateAsyncTask extends AsyncTask<InspeccionEntity, Void, Void>{

        private InspeccionDao asyncTaskDao;

        updateAsyncTask(InspeccionDao dao){ asyncTaskDao = dao; }

        @Override
        protected Void doInBackground(InspeccionEntity... inspeccionEntities) {
            asyncTaskDao.updateInspeccionById(inspeccionEntities[0]);
            return null;
        }
    }

}
