package com.javierpinya.testcamiones_v2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.javierpinya.testcamiones_v2.Clases.TaccatrEntity;
import com.javierpinya.testcamiones_v2.Repositories.TaccatrRepository;

import java.util.List;

public class TaccatrViewModel extends AndroidViewModel {

    private TaccatrRepository taccatrRepository;

    public TaccatrViewModel(@NonNull Application application) {
        super(application);
        taccatrRepository = new TaccatrRepository(application);
    }

    public TaccatrEntity findTaccatrBydId(int id){
        return taccatrRepository.findTaccatrById(id);
    }

    public LiveData<List<TaccatrEntity>> findTaccatrByTransSlo(String transportista, String slo){
        return taccatrRepository.findTaccatrByTransSlo(transportista, slo);
    }

    public LiveData<List<TaccatrEntity>> findTaccatrByTrans(String transportista){
        return taccatrRepository.findTaccatrByTrans(transportista);
    }

    public void insertTaccatr(TaccatrEntity taccatr){
        taccatrRepository.insertTaccatr(taccatr);
    }

    public void deleteTaccatr(TaccatrEntity taccatr){
        taccatrRepository.deleteTaccatr(taccatr);
    }

    public void updateTaccatr(TaccatrEntity taccatr){
        taccatrRepository.updateTaccatrById(taccatr);
    }
}
