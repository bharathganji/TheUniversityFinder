package com.hoopers.theuniversityfinder.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hoopers.theuniversityfinder.R
import com.hoopers.theuniversityfinder.model.FeaturedUniData

class FeaturedUniAdapter(val context: Context,val itemList: ArrayList<FeaturedUniData>): RecyclerView.Adapter<FeaturedUniAdapter.FeaturedUniViewHolder>() {

    class FeaturedUniViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtFUniName = view.findViewById<TextView>(R.id.txtFUniName)
        val txtFUniLoc = view.findViewById<TextView>(R.id.txtFUniLoc)
        val txtFUniCourses = view.findViewById<TextView>(R.id.txtFUniCourse)
        val imfFUniImage = view.findViewById<ImageView>(R.id.imgFUniImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedUniViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_featured_uni,parent,false)

        return FeaturedUniViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: FeaturedUniViewHolder, position: Int) {
        holder.txtFUniName.text = itemList[position].fUniName
        holder.txtFUniLoc.text = itemList[position].fUniLoc
        holder.txtFUniCourses.text = itemList[position].fUniCourses
        holder.imfFUniImage.setImageResource(itemList[position].fUniImage)
    }
}