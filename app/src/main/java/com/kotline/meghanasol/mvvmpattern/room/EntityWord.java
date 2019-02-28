package com.kotline.meghanasol.mvvmpattern.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "word_name")
public class EntityWord {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    @ColumnInfo(name = "word")
    private String word;

    public void setId(int id) {
        this.id = id;
    }


    public EntityWord(String word) {
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public String getWord(){ return word;}
}
