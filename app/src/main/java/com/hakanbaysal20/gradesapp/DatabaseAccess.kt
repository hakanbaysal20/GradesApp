package com.hakanbaysal20.gradesapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseAccess(context:Context):SQLiteOpenHelper(context,"grades",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE grade (grade_id INTEGER PRIMARY KEY AUTOINCREMENT,grade_name TEXT,midterm INTEGER,final INTEGER);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS grade")
        onCreate(db)
    }


}