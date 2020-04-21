package com.hoopers.theuniversityfinder.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hoopers.theuniversityfinder.R
import com.hoopers.theuniversityfinder.adapter.CategoriesAdapter
import com.hoopers.theuniversityfinder.adapter.FeaturedUniAdapter
import com.hoopers.theuniversityfinder.model.FeaturedUniData
import kotlin.random.Random

class FeaturedFragment : Fragment() {
    lateinit var recyclerCategories: RecyclerView
    lateinit var layoutManagerCategories: LinearLayoutManager
    lateinit var myAdapter: CategoriesAdapter
    lateinit var recyclerFeaturedUni: RecyclerView
    lateinit var layoutManagerFeaturedUni: LinearLayoutManager
    lateinit var myAdapter2: FeaturedUniAdapter
    val funiInfoList = arrayListOf<FeaturedUniData>()

    val funiName = arrayListOf<String>("Priceton University","Oxford University","M.I.T","Howard University")
    val funiLoc = arrayListOf<String>("Priceton, United States","Oxford,United Kingdom","Massachusetts, United States","Washington, United States")
    val funiCource = arrayListOf<String>("Courses offered -\nArchitecture, Computational Mathematics, Anthropology ..see more",
    "Courses offered -\nClassics and English, Biology, Chemistry ..see more","Courses offered -\nComp. Engineering, Civil Engineering ..see more",
    "Courses offered -\nBiomedical Sciences, Communication, Journalism ..see more")
    val funiImage = arrayListOf<Int>(R.drawable.image1,R.drawable.image2)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_featured, container, false)

        recyclerCategories = view.findViewById(R.id.recyclerCategories)
        layoutManagerCategories = LinearLayoutManager(activity)
        layoutManagerCategories.orientation = LinearLayoutManager.HORIZONTAL
        recyclerFeaturedUni = view.findViewById(R.id.recyclerFeaturedUni)
        layoutManagerFeaturedUni = LinearLayoutManager(activity)

        myAdapter = CategoriesAdapter(activity as Context,10)
        recyclerCategories.adapter = myAdapter
        recyclerCategories.layoutManager = layoutManagerCategories

        for(i in 0 until 10){
            val random = Random.nextInt(funiName.size)
            funiInfoList.add(FeaturedUniData(funiName[random],funiLoc[random],funiCource[random],funiImage.random()))
        }

        myAdapter2 = FeaturedUniAdapter(activity as Context,funiInfoList)
        recyclerFeaturedUni.adapter = myAdapter2
        recyclerFeaturedUni.layoutManager = layoutManagerFeaturedUni

        return view
    }

}
