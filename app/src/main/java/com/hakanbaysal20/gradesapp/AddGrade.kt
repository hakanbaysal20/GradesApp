package com.hakanbaysal20.gradesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hakanbaysal20.gradesapp.databinding.ActivityAddGradeBinding

class AddGrade : AppCompatActivity() {
    private lateinit var binding:ActivityAddGradeBinding
    private lateinit var vba:DatabaseAccess
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddGradeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vba = DatabaseAccess(this)

        binding.addGradeButton.setOnClickListener {
            val grade_name = binding.editTextLessonName.text.toString()
            val midterm = binding.editTextMidterm.text.toString().toInt()
            val final = binding.editTextFinal.text.toString().toInt()
            Gradesdao().addGrade(vba,grade_name,midterm,final)
            startActivity(Intent(this@AddGrade,MainActivity::class.java))
            finish()
        }

    }
}