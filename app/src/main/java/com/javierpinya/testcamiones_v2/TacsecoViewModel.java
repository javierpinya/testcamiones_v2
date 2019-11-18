package com.javierpinya.testcamiones_v2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.javierpinya.testcamiones_v2.Clases.TacsecoEntity;
import com.javierpinya.testcamiones_v2.Repositories.TacsecoRepository;

import java.util.List;

public class TacsecoViewModel extends AndroidViewModel {

    private List<TacsecoEntity> allTractoras;
    private TacsecoRepository tacsecoRepository;

    public TacsecoViewModel(@NonNull Application application) {
        super(application);
        tacsecoRepository = new TacsecoRepository(application);
    }

    public LiveData<List<TacsecoEntity>> findTacsecoByMatricula(String matricula){
        return tacsecoRepository.findTacsecoByMatricula(matricula);
    }

    public TacsecoEntity findTacsecoById(int id){
        return tacsecoRepository.findTacsecoById(id);
    }

    public LiveData<List<TacsecoEntity>> getAllTacseco(){
        return tacsecoRepository.getAllTacseco();
    }

    public void updateTacsecoById(TacsecoEntity tacsecoEntity){
        tacsecoRepository.updateTacsecoById(tacsecoEntity);
    }

    public void insertTacseco(TacsecoEntity tacsecoEntity){
        tacsecoRepository.insertTacseco(tacsecoEntity);
    }

    public void deleteTacseco(TacsecoEntity tacsecoEntity){
        tacsecoRepository.deleteTacsecoById(tacsecoEntity);
    }

    public void deleteAllTacseco(){
        tacsecoRepository.deleteAllTacseco();
    }



}
