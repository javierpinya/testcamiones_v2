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

    public LiveData<List<TaccondEntity>> findTaccondByDni(String dni){
        return taccondRepository.findTaccondByDni(dni);
    }

    public LiveData<List<TaccondEntity>> findTaccondByApellidos(String apellidos){
        return taccondRepository.findTaccondByApellidos(apellidos);
    }

    public LiveData<List<TaccondEntity>> findTaccondByNombre(String nombre){
        return taccondRepository.findTaccondByNombre(nombre);
    }

    public TaccondEntity findTaccondById(int id){
        return taccondRepository.findTaccondById(id);
    }

    public void insertTaccond(TaccondEntity taccond){
        taccondRepository.insertTaccond(taccond);
    }

    public void updateTaccond(TaccondEntity taccond){
        taccondRepository.updateTaccond(taccond);
    }

    public void deleteTaccond(TaccondEntity taccond){
        taccondRepository.deleteTaccondById(taccond);
    }

    public void deleteAllTaccond(){
        taccondRepository.deleteAllTaccond();
    }

}
