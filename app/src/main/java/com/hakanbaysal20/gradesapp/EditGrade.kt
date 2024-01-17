package com.hakanbaysal20.gradesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hakanbaysal20.gradesapp.databinding.ActivityEditGradeBinding

class EditGrade : AppCompatActivity() {
    private lateinit var binding:ActivityEditGradeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditGradeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}