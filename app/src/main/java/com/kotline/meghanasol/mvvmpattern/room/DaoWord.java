package com.kotline.meghanasol.mvvmpattern.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DaoWord {
    @Insert
     void insert(EntityWord word);
    @Query("DELETE  FROM word_name")
     void deleteAll();
    @Query("SELECT * FROM word_name ORDER BY  word ASC")
     LiveData<List<EntityWord>> getAllWords();
}
