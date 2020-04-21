package com.hoopers.theuniversityfinder.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.hoopers.theuniversityfinder.R
import com.hoopers.theuniversityfinder.activity.HomeActivity
import com.hoopers.theuniversityfinder.adapter.FilterCountriesAdapter
import kotlinx.android.synthetic.main.fragment_course_filter.*

class CourseFilterFragment : Fragment() {

    lateinit var imgCourseFilterBack: ImageView
    lateinit var mySpinnerAdapter: ArrayAdapter<CharSequence>
    lateinit var spinnerCountries: Spinner
    lateinit var recyclerFilterCountries: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var myAdapter: FilterCountriesAdapter
    val countryInfoList = arrayListOf<String>()
    lateinit var txtCourseFilterApply: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_course_filter, container, false)

        imgCourseFilterBack = view.findViewById(R.id.imgFilterBack)
        spinnerCountries = view.findViewById(R.id.spinnerCountries)
        recyclerFilterCountries = view.findViewById(R.id.recyclerFilterCountries)
        layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        txtCourseFilterApply = view.findViewById(R.id.txtCouseFilterApply)


        txtCourseFilterApply.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.push_right_in,R.anim.push_right_out).replace(R.id.frameLayout, CoursesFragment()).commit()
            (activity as HomeActivity).myNavigationView.visibility = View.VISIBLE
        }


        mySpinnerAdapter = ArrayAdapter.createFromResource(activity as Context,R.array.countries_array,R.layout.my_spinner_text)
        spinnerCountries.adapter = mySpinnerAdapter

        spinnerCountries.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if(position != 0){
                    val countryName = spinnerCountries.selectedItem.toString()

                    if(!countryInfoList.contains(countryName)) {
                        countryInfoList.add(countryName)
                        myAdapter = FilterCountriesAdapter(activity as Context, countryInfoList)
                        recyclerFilterCountries.adapter = myAdapter
                        recyclerFilterCountries.layoutManager = layoutManager
                    }else{
                        Toast.makeText(activity as Context,"Country already added.",Toast.LENGTH_SHORT).show()
                    }
                    spinnerCountries.setSelection(0)
                }
            }

        }

        imgCourseFilterBack.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.push_right_in,R.anim.push_right_out).replace(R.id.frameLayout, CoursesFragment()).commit()
            (activity as HomeActivity).myNavigationView.visibility = View.VISIBLE
        }


        return view
    }

}
