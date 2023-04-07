package com.example.my2.DataSource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.my2.Model.CinemaInfo;
import com.example.my2.R;

import java.util.ArrayList;
import java.util.List;

public class CinemaDataSource {
    public static LiveData<List<CinemaInfo>> setInitialData(){
        MutableLiveData<List<CinemaInfo>> result = new MutableLiveData<>();
        ArrayList<CinemaInfo> cinemaInfo = new ArrayList<>();
        cinemaInfo.add(new CinemaInfo(R.mipmap.pantera_foreground,"Чёрная Пантера"));
        cinemaInfo.add(new CinemaInfo(R.mipmap.avatar_foreground,"Аватар"));
        cinemaInfo.add(new CinemaInfo(R.mipmap.djon_foreground,"Индиана Джонс"));
        cinemaInfo.add(new CinemaInfo(R.mipmap.sumerki_foreground,"Сумерки"));
        result.setValue(cinemaInfo);
        return result;
    }
}
