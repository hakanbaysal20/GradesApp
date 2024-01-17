package com.hakanbaysal20.gradesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hakanbaysal20.gradesapp.databinding.ActivityEditGradeBinding

class EditGrade : AppCompatActivity() {
    private lateinit var binding:ActivityEditGradeBinding
    private lateinit var dba:DatabaseAccess
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditGradeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dba = DatabaseAccess(this)
        val grade = intent.getSerializableExtra("grade") as Grade
            binding.editTextGradeFinal.setText("${grade.final}")
            binding.editTextGradeMidterm.setText("${grade.midterm}")
            binding.editTextGradeLessonName.setText("${grade.grade_name}")

        binding.editGradeButton.setOnClickListener {
        val grade_name = binding.editTextGradeLessonName.text.toString()
        val midterm = binding.editTextGradeMidterm.text.toString().toInt()
        val final = binding.editTextGradeFinal.text.toString().toInt()
            Gradesdao().editGrade(dba, grade_name,midterm,final,grade.grade_id)
        }

    }
}