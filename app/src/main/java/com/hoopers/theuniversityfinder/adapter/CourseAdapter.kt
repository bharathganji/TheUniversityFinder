package com.hoopers.theuniversityfinder.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hoopers.theuniversityfinder.R
import com.hoopers.theuniversityfinder.model.CourseData

class CourseAdapter(val context: Context, val itemList: ArrayList<CourseData>, val onApply: OnApply): RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    class CourseViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtCFType = view.findViewById<TextView>(R.id.txtCFType)
        val txtCFUni = view.findViewById<TextView>(R.id.txtCFUni)
        val txtCFLoc = view.findViewById<TextView>(R.id.txtCFLoc)
        val imgCFType = view.findViewById<ImageView>(R.id.imgCFType)
        val imgCFSave = view.findViewById<ImageView>(R.id.imgCFSave)
        val txtCFStudents = view.findViewById<TextView>(R.id.txtCFStudents)
        val txtCFApply = view.findViewById<TextView>(R.id.txtCFApply)
        val llCFinder = view.findViewById<LinearLayout>(R.id.llCFinder)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_course_finder,parent,false)

        return CourseViewHolder(view)
    }

    override fun getItemCount(): Int {
       return itemList.size
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.txtCFType.text = itemList[position].cfType
        holder.txtCFUni.text = itemList[position].cfUni
        holder.txtCFLoc.text = itemList[position].cfLoc
        holder.txtCFStudents.text = itemList[position].cfStudents

        if(itemList[position].cfSaved){
            holder.imgCFSave.setImageResource(R.drawable.nav_icon_saved_selected)
        }else{
            holder.imgCFSave.setImageResource(R.drawable.nav_icon_saved)
        }

        holder.imgCFType.setImageResource(itemList[position].cfTypeImage)

        holder.txtCFApply.setOnClickListener {
            onApply.onApply(itemList[position])
        }

        holder.llCFinder.setOnClickListener {

        }

    }

    interface OnApply{
        fun onApply(itemList: CourseData)
    }

}