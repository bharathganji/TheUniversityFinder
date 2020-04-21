package com.hoopers.theuniversityfinder.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hoopers.theuniversityfinder.R

class CategoriesAdapter(val context: Context,val itemList: Int): RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    class CategoriesViewHolder(view: View): RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_categories,parent,false)

        return CategoriesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {

    }
}