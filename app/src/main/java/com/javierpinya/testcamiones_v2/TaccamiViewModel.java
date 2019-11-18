package com.javierpinya.testcamiones_v2;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.javierpinya.testcamiones_v2.Clases.TaccamiEntity;
import com.javierpinya.testcamiones_v2.Repositories.TaccamiRepository;

import java.util.List;

public class TaccamiViewModel extends AndroidViewModel {

    private LiveData<List<TaccamiEntity>> allTaccami;
    private TaccamiRepository taccamiRepository;

    public TaccamiViewModel(Application application){
        super(application);

        taccamiRepository = new TaccamiRepository(application);
        allTaccami = taccamiRepository.findAllTaccami();
    }

    public LiveData<List<TaccamiEntity>> findTaccamiByCodVehiculo(int cod_vehiculo){
        return taccamiRepository.findTaccamiByCodVehiculo(cod_vehiculo);
    }

    public LiveData<List<TaccamiEntity>> findTaccamiByTMatricula(String matricula){
        return taccamiRepository.findTaccamiByTMatricula(matricula);
    }

    public LiveData<List<TaccamiEntity>> findTaccamiByCMatricula(String matricula){
        return taccamiRepository.findTaccamiByCMatricula(matricula);
    }

    public LiveData<List<TaccamiEntity>> findAllVehiculos(){
        return taccamiRepository.findAllTaccami();
    }

    public void insertarVehiculo(TaccamiEntity taccamiEntity){
        taccamiRepository.insertTaccami(taccamiEntity);
    }

    public void updateVehiculo(TaccamiEntity taccamiEntity){
        taccamiRepository.updateTaccamiById(taccamiEntity);
    }

    public void deleteTaccamiById(TaccamiEntity taccamiEntity){
        taccamiRepository.deleteTaccamiById(taccamiEntity);
    }

    public void deleteAllTaccami(){
        taccamiRepository.deleteAllTaccami();
    }



}

