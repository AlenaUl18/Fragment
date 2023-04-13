package com.example.my2.DataSource.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.my2.DataSource.User;

@Database(entities = {User.class}, version = 1)
public abstract class DataBase extends RoomDatabase {
    private static final String DataBase_name = "users";
    private static DataBase instance;

    public static synchronized DataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), DataBase.class, DataBase_name)
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract userDao userDao();
}
