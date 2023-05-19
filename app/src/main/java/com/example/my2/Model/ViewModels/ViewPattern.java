package com.example.my2.Model.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.my2.Model.CinemaInfo;
import com.example.my2.Repositoryes.CinemaRepos;

import java.util.List;

public class ViewPattern extends ViewModel {
    public LiveData<List<CinemaInfo>> list1;
    public ViewPattern(){
        CinemaViewPattern();
    }
    public void CinemaViewPattern(){
        CinemaRepos cinema=new CinemaRepos();
        list1= cinema.generateData();
    }
}

