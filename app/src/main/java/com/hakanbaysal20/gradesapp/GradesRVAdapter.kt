package com.hakanbaysal20.gradesapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

 class GradesRVAdapter(private var mContext:Context,private var gradeList:ArrayList<Grade>)
     :RecyclerView.Adapter<GradesRVAdapter.GradesRvAdapterHolder>(){

    inner class GradesRvAdapterHolder(view: View):RecyclerView.ViewHolder(view){

        var grade_name: TextView
        var midterm: TextView
        var final: TextView
        var cardView:CardView
        init {
            grade_name = view.findViewById(R.id.textLesson)
            midterm = view.findViewById(R.id.textMidterm)
            final = view.findViewById(R.id.textFinal)
            cardView = view.findViewById(R.id.grades_card)
        }
    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GradesRvAdapterHolder {
         val binding = LayoutInflater.from(mContext).inflate(R.layout.grades_view,parent,false)
         return GradesRvAdapterHolder(binding)
     }

     override fun getItemCount(): Int {
         return gradeList.size
     }

     override fun onBindViewHolder(holder: GradesRvAdapterHolder, position: Int) {
         val grade = gradeList.get(position)
         holder.grade_name.text = grade.grade_name
         holder.final.text = grade.final.toString()
         holder.midterm.text = grade.midterm.toString()
         holder.cardView.setOnClickListener {
             val intent = Intent(mContext,EditGrade::class.java)
             intent.putExtra("final",grade.final)
             intent.putExtra("midterm",grade.midterm)
             intent.putExtra("grade_name",grade.grade_name)
             intent.putExtra("grade",Grade(grade.grade_id,grade.grade_name,grade.midterm,grade.final))
             mContext.startActivity(intent)
         }

     }


 }