package com.javierpinya.testcamiones_v2.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.javierpinya.testcamiones_v2.AppDatabase;
import com.javierpinya.testcamiones_v2.Clases.TaccatrEntity;
import com.javierpinya.testcamiones_v2.Dao.TaccatrDao;

import java.util.List;

public class TaccatrRepository {

    private TaccatrDao taccatrDao;

    public TaccatrRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        taccatrDao = db.taccatrDao();
    }

    public TaccatrEntity findTaccatrById(int id){
        return taccatrDao.findTaccatrById(id);
    }

    public LiveData<List<TaccatrEntity>> findTaccatrByTransSlo(String transportista, String slo){
        return taccatrDao.findTaccatrByTransSlo(transportista, slo);
    }

    public LiveData<List<TaccatrEntity>> findTaccatrByTrans(String transportista){
        return taccatrDao.findTaccatrByTrans(transportista);
    }

    public void insertTaccatr(TaccatrEntity taccatr){
        new insertAsyncTask(taccatrDao).execute(taccatr);
    }

    private static class insertAsyncTask extends AsyncTask<TaccatrEntity, Void, Void>{

        private TaccatrDao asyncTaskDao;

        insertAsyncTask(TaccatrDao dao){ asyncTaskDao = dao; }

        @Override
        protected Void doInBackground(TaccatrEntity... taccatrEntities) {
            asyncTaskDao.insertTaccatr(taccatrEntities[0]);
            return null;
        }
    }

    public void deleteTaccatr(TaccatrEntity taccatr){
        new deleteAsyncTask(taccatrDao).execute(taccatr);
    }

    private static class deleteAsyncTask extends AsyncTask<TaccatrEntity, Void, Void>{

        private TaccatrDao asyncTaskDao;

        deleteAsyncTask(TaccatrDao dao){ asyncTaskDao = dao; }

        @Override
        protected Void doInBackground(TaccatrEntity... taccatrEntities) {
            asyncTaskDao.deleteTaccatrById(taccatrEntities[0]);
            return null;
        }
    }

    public void updateTaccatrById(TaccatrEntity taccatr){
        new updateAsyncTask(taccatrDao).execute(taccatr);
    }

    private static class updateAsyncTask extends AsyncTask<TaccatrEntity, Void, Void>{

        private TaccatrDao asyncTaskDao;

        updateAsyncTask(TaccatrDao dao){ asyncTaskDao = dao; }

        @Override
        protected Void doInBackground(TaccatrEntity... taccatrEntities) {
            asyncTaskDao.updateTaccatrById(taccatrEntities[0]);
            return null;
        }
    }

    public void deleteAllTaccatr(){
        new deleteAllAsyncTask(taccatrDao).execute();
    }

    private static class deleteAllAsyncTask extends AsyncTask<TaccatrEntity, Void, Void>{
        private TaccatrDao asyncTaskDao;

        deleteAllAsyncTask(TaccatrDao dao){ asyncTaskDao = dao; }

        @Override
        protected Void doInBackground(TaccatrEntity... taccatrEntities) {
            asyncTaskDao.deleteAllTaccatr();
            return null;
        }
    }
}
