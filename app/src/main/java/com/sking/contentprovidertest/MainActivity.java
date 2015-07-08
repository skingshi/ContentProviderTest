package com.sking.contentprovidertest;

import android.app.Activity;
import android.content.ContentValues;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.write);
        EditText tv = (EditText) findViewById(R.id.tvWrite);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ContentValues values = new ContentValues();
        values.put("name","sking1");
        values.put("name","sking2");
        values.put("name","sking3");
        values.put("name","sking4");
        getContentResolver().insert(MyContentProvider.URI, values);
        Log.w("++++","insert complete");
    }
}
