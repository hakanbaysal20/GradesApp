package com.hakanbaysal20.gradesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hakanbaysal20.gradesapp.databinding.ActivityAddGradeBinding

class AddGrade : AppCompatActivity() {
    private lateinit var binding:ActivityAddGradeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddGradeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val vba = DatabaseAccess(this)
        val ed = "matematik"
        val not = 50
        val note= 50
        binding.addGradeButton.setOnClickListener {
            Gradesdao().addGrade(vba,ed,not,note)
        }

    }
}