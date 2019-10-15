package com.javierpinya.testcamiones_v2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.javierpinya.testcamiones_v2.Clases.TaccondEntity;
import com.javierpinya.testcamiones_v2.Repositories.TaccondRepository;

import java.util.List;

public class TaccondViewModel extends AndroidViewModel {

    private TaccondRepository taccondRepository;

    public TaccondViewModel(@NonNull Application application) {
        super(application);
        taccondRepository = new TaccondRepository(application);
    }

    public LiveData<List<TaccondEntity>> findTaccondByConductor(String conductor){
        return taccondRepository.findTaccondByConductor(conductor);
    }

    public LiveData<List<TaccondEntity>> findAllTaccond(){
        return taccondRepository.findAllTaccond();
    }

    public void insertTaccond(TaccondEntity taccond){
        taccondRepository.insertTaccond(taccond);
    }

    public void updateTaccond(TaccondEntity taccond){
        taccondRepository.updateTaccond(taccond);
    }

    public void deleteTaccond(TaccondEntity taccond){
        taccondRepository.deleteTaccond(taccond);
    }

    public void deleteAllTaccond(){
        taccondRepository.deleteAllTaccond();
    }

}
