package com.sking.contentproviderread;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {
    private Uri URI = Uri.parse("content://com.sking.contentProvider");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Cursor cursor = getContentResolver().query(URI, null, null, null, null);
        cursor.moveToFirst();
        for (int i =0;i<cursor.getCount();i++)
        {
            String value = cursor.getString(cursor.getColumnIndex("name"));
            Log.w("=========",value);
            cursor.moveToNext();
        }
    }
}
