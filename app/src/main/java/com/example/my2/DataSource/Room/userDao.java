package com.example.my2.DataSource.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.my2.DataSource.User;

import java.util.List;
@Dao
public interface userDao {
    @Query("SELECT * FROM users")
    LiveData<List<User>> getUsers();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUser(User user);
}
