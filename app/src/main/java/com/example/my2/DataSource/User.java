package com.example.my2.DataSource;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Users")
public class User {
    @ColumnInfo(name = "Name")
    private String name;
    @PrimaryKey
    @NonNull
    private String pass;
    @ColumnInfo(name = "Promocode")
    private String prom;

    public User(String name, @NonNull String pass, String prom) {
        this.name = name;
        this.pass = pass;
        this.prom = prom;
    }
    public String getName() {
        return name;
    }

    @NonNull
    public String getPass() {
        return pass;
    }

    public String getProm() {
        return prom;
    }
}
