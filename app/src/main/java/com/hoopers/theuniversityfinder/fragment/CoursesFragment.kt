package com.hoopers.theuniversityfinder.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.hoopers.theuniversityfinder.R
import com.hoopers.theuniversityfinder.activity.HomeActivity
import com.hoopers.theuniversityfinder.adapter.CourseAdapter
import com.hoopers.theuniversityfinder.model.CourseData

class CoursesFragment : Fragment(),CourseAdapter.OnApply {

    lateinit var recyclerCourseFinder: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var myAdapter: CourseAdapter
    val courseInfoList = arrayListOf<CourseData>()
    lateinit var txtCoursesFilter: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_courses, container, false)

        recyclerCourseFinder = view.findViewById(R.id.recyclerCourseFinder)
        layoutManager = LinearLayoutManager(activity)
        txtCoursesFilter = view.findViewById(R.id.txtCoursesFilter)

        txtCoursesFilter.setOnClickListener {

            (activity as HomeActivity).myNavigationView.visibility = View.GONE
            activity!!.supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.push_left_in,R.anim.push_left_out).replace(R.id.frameLayout,CourseFilterFragment()).commit()
        }

        for(i in 0 until 20){
            courseInfoList.add(
                CourseData(
                "MA American Studies (Part Time)",
                    "James Madison University",
                    "Australia",
                    "245",
                    R.drawable.icon_hat_diploma,
                    false
            )
            )
        }

        myAdapter = CourseAdapter(activity as Context,courseInfoList,this)
        recyclerCourseFinder.adapter = myAdapter
        recyclerCourseFinder.layoutManager = layoutManager

        return view
    }

    override fun onApply(itemList: CourseData) {
        activity!!.supportFragmentManager.beginTransaction().replace(R.id.frameLayout,CourseDescriptionFragment()).commit()
    }

}
