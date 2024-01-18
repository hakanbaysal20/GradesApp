package com.hakanbaysal20.gradesapp

import android.content.ContentValues

class Gradesdao() {

    fun getGrades(vba:DatabaseAccess):ArrayList<Grade> {
        val vb = vba.writableDatabase
        val cursor = vb.rawQuery("SELECT * FROM grade",null)
            var list = ArrayList<Grade>()
            val grade_name = cursor.getColumnIndex("grade_name")
            val grade_id = cursor.getColumnIndex("grade_id")
            val final = cursor.getColumnIndex("final")
            val midterm = cursor.getColumnIndex("midterm")
            while (cursor.moveToNext()) {
                val grade = Grade(
                    cursor.getInt(grade_id),
                    cursor.getString(grade_name),
                    cursor.getInt(midterm),
                    cursor.getInt(final)
                )
                list.add(grade)
            }
            return list
    }
    fun addGrade(vba:DatabaseAccess,grade_name:String,midterm:Int,final:Int) {
        val db = vba.writableDatabase
        val values = ContentValues()
        values.put("grade_name",grade_name)
        values.put("midterm",midterm)
        values.put("final",final)
        db.insertOrThrow("grade",null,values)
        db.close()
    }
    fun editGrade(vba:DatabaseAccess,grade_name: String,midterm: Int,final: Int,grade_id:Int) {
        val db = vba.writableDatabase
        val values = ContentValues()
        values.put("grade_name",grade_name)
        values.put("midterm",midterm)
        values.put("final",final)
        db.update("grade",values,"grade_id=?", arrayOf(grade_id.toString()))
        db.close()
    }
    fun deleteGrade(vba: DatabaseAccess,grade_id:Int){
        val db = vba.writableDatabase
        db.delete("grade","grade_id=?", arrayOf(grade_id.toString()))
        db.close()
    }
}