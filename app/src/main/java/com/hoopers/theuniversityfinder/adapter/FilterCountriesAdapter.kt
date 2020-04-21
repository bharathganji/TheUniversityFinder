package com.hoopers.theuniversityfinder.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hoopers.theuniversityfinder.R
import kotlinx.android.synthetic.main.recycler_filter_countries.view.*

class FilterCountriesAdapter(val context: Context,val itemList: ArrayList<String>): RecyclerView.Adapter<FilterCountriesAdapter.FilterCountriesViewHolder>() {

    class FilterCountriesViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtFilterCountryName: TextView = view.findViewById(R.id.txtFilterCountryName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterCountriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_filter_countries,parent,false)

        return FilterCountriesViewHolder(view)
    }

    override fun getItemCount(): Int {
       return itemList.size
    }

    override fun onBindViewHolder(holder: FilterCountriesViewHolder, position: Int) {
        holder.txtFilterCountryName.text = itemList[position]

        holder.txtFilterCountryName.setOnClickListener {
            itemList.remove(itemList[position])
            notifyDataSetChanged()
        }
    }
}