package com.javierpinya.testcamiones_v2;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.javierpinya.testcamiones_v2.Clases.TplcprtEntity;
import com.javierpinya.testcamiones_v2.Repositories.TplcprtRepository;

import java.util.List;

public class TplcprtViewModel extends AndroidViewModel {

    private List<TplcprtEntity> allTplcprt;
    private TplcprtRepository tplcprtRepository;

    public TplcprtViewModel(@NonNull Application application) {
        super(application);
        tplcprtRepository = new TplcprtRepository(application);
    }

    public LiveData<List<TplcprtEntity>> findTplcprtById(int cisterna){
        return tplcprtRepository.findTplcprtById(cisterna);
    }

    public LiveData<List<TplcprtEntity>> findTplcprtByTag(int tag){
        return tplcprtRepository.findTplcprtByTag(tag);
    }

    public void insertTplcprt(TplcprtEntity tplcprtEntity){
        tplcprtRepository.insertTplcprt(tplcprtEntity);
    }

    public void updateTplcprt(TplcprtEntity tplcprtEntity){
        tplcprtRepository.updateTplcprt(tplcprtEntity);
    }

    public void deleteTplcprtById(TplcprtEntity tplcprtEntity){
        tplcprtRepository.deleteTplcprtById(tplcprtEntity);
    }

    public void deleteAllTplcprt(){
        tplcprtRepository.deleteAllTplcprt();
    }
}
