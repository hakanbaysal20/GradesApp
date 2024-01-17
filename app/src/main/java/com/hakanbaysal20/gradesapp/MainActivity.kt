package com.hakanbaysal20.gradesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hakanbaysal20.gradesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter:GradesRVAdapter
    private lateinit var vba:DatabaseAccess
    private lateinit var gradeList:ArrayList<Grade>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val vba = DatabaseAccess(this)

        binding.gradeRv.setHasFixedSize(true)
        binding.gradeRv.layoutManager = LinearLayoutManager(applicationContext)

        gradeList = Gradesdao().getGrades(vba)
        adapter = GradesRVAdapter(this,gradeList)
        binding.gradeRv.adapter = adapter
        binding.buttonAdd.setOnClickListener {
            startActivity(Intent(this@MainActivity,AddGrade::class.java))
        }
    }
}