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



}
