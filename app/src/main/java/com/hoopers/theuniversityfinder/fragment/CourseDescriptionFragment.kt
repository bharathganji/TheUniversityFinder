package com.hoopers.theuniversityfinder.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.core.view.get
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

import com.hoopers.theuniversityfinder.R
import com.hoopers.theuniversityfinder.activity.HomeActivity
import com.hoopers.theuniversityfinder.adapter.CourseDesPageAdapter

class CourseDescriptionFragment : Fragment() {

    lateinit var courseDesPageAdapter: CourseDesPageAdapter
    val fragList = arrayListOf<Fragment>()
    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout
    lateinit var txtCourseDesBack: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_course_description, container, false)

        viewPager = view.findViewById(R.id.viewPager)
        tabLayout = view.findViewById(R.id.tabLayout)
        txtCourseDesBack = view.findViewById(R.id.txtCourseDesBack)

        fragList.add(CourseDesOverview())
        fragList.add(CourseDesInstructor())
        fragList.add(CourseDesCurriculum())
        fragList.add(CourseDesReview())

        courseDesPageAdapter = CourseDesPageAdapter(activity!!.supportFragmentManager,fragList)
        viewPager.adapter = courseDesPageAdapter
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.getTabAt(0)!!.text = "Overview"
        tabLayout.getTabAt(1)!!.text = "Instructor"
        tabLayout.getTabAt(2)!!.text = "Curriculum"
        tabLayout.getTabAt(3)!!.text = "Review"

        txtCourseDesBack.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.fadein,R.anim.fadeout)
                .replace(R.id.frameLayout, CoursesFragment()).commit()
        }

        return view
    }

}
