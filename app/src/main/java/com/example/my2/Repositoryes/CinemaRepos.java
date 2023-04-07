package com.example.my2.Repositoryes;

import androidx.lifecycle.LiveData;

import com.example.my2.DataSource.CinemaDataSource;
import com.example.my2.Model.CinemaInfo;

import java.util.List;

public class CinemaRepos {
    public LiveData<List<CinemaInfo>> generateData() {
        return CinemaDataSource.setInitialData();
    }
}
