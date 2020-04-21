package com.hoopers.theuniversityfinder.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class CourseDesPageAdapter(
    val fragmentManager: FragmentManager,
    val itemList: ArrayList<Fragment>
) : FragmentPagerAdapter(fragmentManager) {


    override fun getItem(position: Int): Fragment {
        return itemList[position]
    }

    override fun getCount(): Int {
        return itemList.size
    }
}