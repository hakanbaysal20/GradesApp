package com.hakanbaysal20.gradesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.util.Log
import androidx.core.text.toSpannable
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
        vba = DatabaseAccess(this)
        binding.gradeRv.setHasFixedSize(true)
        binding.gradeRv.layoutManager = LinearLayoutManager(applicationContext)
        gradeList = Gradesdao().getGrades(vba)

        // toolbar
        binding.toolbar.setSubtitle("Avarage:${calculateTotalAvarage(gradeList)}")
        binding.toolbar.setSubtitleTextAppearance(this, com.google.android.material.R.style.TextAppearance_Material3_BodyMedium)
        binding.toolbar.setSubtitleTextColor(resources.getColor(R.color.white))
        binding.toolbar.setTitleMargin(0,0,0,0)
        binding.toolbar.setTitle("Grades")
        binding.toolbar.setTitleTextAppearance(this, androidx.appcompat.R.style.TextAppearance_AppCompat_Display1)
        binding.toolbar.setTitleTextColor(resources.getColor(R.color.white))

        setSupportActionBar(binding.toolbar)
        // rv adapter
        adapter = GradesRVAdapter(this,gradeList)
        binding.gradeRv.adapter = adapter
        // fab
        binding.buttonAdd.setOnClickListener {
            startActivity(Intent(this@MainActivity,AddGrade::class.java))
        }
    }
    fun calculateAvarage(midterm:Int,final:Int):Int {
        val total = (midterm + final) / 2
        Log.e("total",total.toString())
        return  total.toInt()
    }
    fun calculateTotalAvarage(list:ArrayList<Grade>):Int {
        var total = 0
        for (i in list){
          total = total + calculateAvarage(i.midterm,i.final)
        }

        return total/list.size
    }
}