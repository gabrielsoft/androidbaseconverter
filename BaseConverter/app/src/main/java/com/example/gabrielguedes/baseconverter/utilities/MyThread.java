package com.example.gabrielguedes.baseconverter.utilities;

import android.os.AsyncTask;
import android.util.Log;

import com.example.gabrielguedes.baseconverter.components.FabPlus;

/**
 * Created by Gabriel Guedes on 16/12/2015.
 */

public class MyThread extends AsyncTask<Void,Void,Void> {
    private FabPlus fab;

    public MyThread(FabPlus fab){
        this.fab = fab;
    }

    @Override
    protected Void doInBackground(Void... params){
        fab.animate();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Log.e("INTERRUPTED EXCEPTION",e.getMessage());
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        fab.animate();
    }
}