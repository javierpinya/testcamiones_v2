package com.javierpinya.testcamiones_v2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.javierpinya.testcamiones_v2.Clases.InspeccionEntity;
import com.javierpinya.testcamiones_v2.Repositories.InspeccionRepository;

import java.util.List;

public class InspeccionViewModel extends AndroidViewModel {

    private InspeccionRepository inspeccionRepository;


    public InspeccionViewModel(@NonNull Application application) {
        super(application);
        inspeccionRepository = new InspeccionRepository(application);
    }

    public LiveData<List<InspeccionEntity>> getAllInspeccion(){
        return inspeccionRepository.getAllInspecciones();
    }

    public InspeccionEntity findInspeccionByInspeccion(String inspeccion){
        return inspeccionRepository.findInspeccionByInspeccion(inspeccion);
    }

    public int findIdInspeccionByInspeccion(String inspeccion){
        return inspeccionRepository.findIdInspeccionByInspeccion(inspeccion);
    }

    public LiveData<List<InspeccionEntity>> findInspeccionByInspector(String inspector){
        return inspeccionRepository.findInspeccionByInspector(inspector);
    }

    public LiveData<List<InspeccionEntity>> findInspeccionByInstalacion(String instalacion){
        return inspeccionRepository.findInspeccionByInstalacion(instalacion);
    }

    public LiveData<List<InspeccionEntity>> findInspeccionByTransportista(String transportista){
        return inspeccionRepository.findInspeccionByTransportista(transportista);
    }


    public LiveData<List<InspeccionEntity>> findInspeccionByTractora(String tractora){
        return inspeccionRepository.findInspeccionByTractora(tractora);
    }


    public LiveData<List<InspeccionEntity>> findInspeccionByCisterna(String cisterna){
        return inspeccionRepository.findInspeccionByCisterna(cisterna);
    }

    public LiveData<List<InspeccionEntity>> findInspeccionByConductor(String conductor){
        return inspeccionRepository.findInspeccionByConductor(conductor);
    }

    public void insertarInspeccion(InspeccionEntity inspeccionEntity){
        inspeccionRepository.insert(inspeccionEntity);
    }

    public void borrarInspeccion(InspeccionEntity inspeccionEntity){
        inspeccionRepository.deleteInspeccionById(inspeccionEntity);
    }

    public void updateInspeccionById(InspeccionEntity inspeccionEntity){
        inspeccionRepository.updateInspeccionById(inspeccionEntity);
    }
}
