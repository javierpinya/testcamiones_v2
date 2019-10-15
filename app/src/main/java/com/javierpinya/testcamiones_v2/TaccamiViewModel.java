package com.javierpinya.testcamiones_v2;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.javierpinya.testcamiones_v2.Clases.TaccamiEntity;
import com.javierpinya.testcamiones_v2.Repositories.TaccamiRepository;

import java.util.List;

public class TaccamiViewModel extends AndroidViewModel {


    private List<TaccamiEntity> allVehiculos;
    private TaccamiRepository taccamiRepository;

    public TaccamiViewModel(Application application){
        super(application);

        taccamiRepository = new TaccamiRepository(application);
    }


    public LiveData<List<TaccamiEntity>> getAllVehiculos(){
        return taccamiRepository.encuentraVehiculos();
    }

    public void insertarVehiculo(TaccamiEntity taccamiEntity){
        taccamiRepository.insert(taccamiEntity);
    }



}

