package com.kotline.meghanasol.mvvmpattern.room;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {

    private DaoWord mWordDao;
    private LiveData<List<EntityWord>> mAllWords;


    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.daoWord();
        mAllWords = mWordDao.getAllWords();
    }

    LiveData<List<EntityWord>> getAllWords() {
        return mAllWords;
    }


    public void insert (EntityWord word) {
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<EntityWord, Void, Void> {

        private DaoWord mAsyncTaskDao;

        insertAsyncTask(DaoWord dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final EntityWord... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
