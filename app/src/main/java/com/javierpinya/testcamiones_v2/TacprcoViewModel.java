package com.javierpinya.testcamiones_v2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.javierpinya.testcamiones_v2.Clases.TacprcoEntity;
import com.javierpinya.testcamiones_v2.Repositories.TacprcoRepository;

import java.util.List;


public class TacprcoViewModel extends AndroidViewModel {

    private List<TacprcoEntity> tacprcoEntities;
    private TacprcoRepository tacprcoRepository;


    public TacprcoViewModel(@NonNull Application application) {
        super(application);
        tacprcoRepository = new TacprcoRepository(application);
    }

    public LiveData<List<TacprcoEntity>> findTacprcoByMatricula(String matricula){
        return tacprcoRepository.findTacprcoByMatricula(matricula);
    }

    public TacprcoEntity findTacprcoById(int id){
        return tacprcoRepository.findTacprcoById(id);
    }

    public void updateTacprcoById(TacprcoEntity tacprcoEntity){
        tacprcoRepository.updateTacprcoById(tacprcoEntity);
    }

    public void insertTacprco(TacprcoEntity tacprcoEntity){
        tacprcoRepository.insertTacprco(tacprcoEntity);
    }

    public void deleteTacprco(TacprcoEntity tacprcoEntity){
        tacprcoRepository.deleteTacprcoById(tacprcoEntity);
    }


}
