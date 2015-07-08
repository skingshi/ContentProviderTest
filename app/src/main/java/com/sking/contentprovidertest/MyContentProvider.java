package com.sking.contentprovidertest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    SQLiteDatabase database;
    public static String CREATE_TABLE_SQL = "create table test( id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                            " name TEXT NOT NULL)";
    public static final Uri URI = Uri.parse("content://com.sking.contentProvider");
    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        database.insert("test", "id", values);
//        database.close();
        return null;
    }

    @Override
    public boolean onCreate() {
        database = getContext().openOrCreateDatabase("my.db", Context.MODE_PRIVATE,null);
        database.execSQL(CREATE_TABLE_SQL);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Cursor cursor  = database.query("test",null,null,null,null,null,null);
       return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
