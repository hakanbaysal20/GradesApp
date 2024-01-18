package com.hakanbaysal20.gradesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.graphics.green
import com.hakanbaysal20.gradesapp.databinding.ActivityEditGradeBinding

class EditGrade : AppCompatActivity() {
    private lateinit var binding:ActivityEditGradeBinding
    private lateinit var dba:DatabaseAccess
    private lateinit var grade:Grade
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditGradeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //database access
        dba = DatabaseAccess(this)

        //toolbar
        binding.toolbar3.setTitle("Edit grade")
        binding.toolbar3.setTitleTextAppearance(this, androidx.appcompat.R.style.TextAppearance_AppCompat_Display1)
        binding.toolbar3.setTitleTextColor(resources.getColor(R.color.white))
        setSupportActionBar(binding.toolbar3)
        // intent getObject
        grade = intent.getSerializableExtra("grade") as Grade
        // object properties added to the edittexts
        binding.editTextGradeFinal.setText("${grade.final}")
        binding.editTextGradeMidterm.setText("${grade.midterm}")
        binding.editTextGradeLessonName.setText("${grade.grade_name}")
        // edit grade
        binding.editGradeButton.setOnClickListener {

        val grade_name = binding.editTextGradeLessonName.text.toString()
        val midterm = binding.editTextGradeMidterm.text.toString().toInt()
        val final = binding.editTextGradeFinal.text.toString().toInt()

            Gradesdao().editGrade(dba, grade_name,midterm,final,grade.grade_id)
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.actionDelete -> {
                Gradesdao().deleteGrade(dba,grade.grade_id)
                return true
            }
            R.id.actionEdit ->{
                Log.e("asdasdasd","asdasd")
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}