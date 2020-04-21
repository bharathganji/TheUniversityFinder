package com.hoopers.theuniversityfinder.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hoopers.theuniversityfinder.fragment.FeaturedFragment
import com.hoopers.theuniversityfinder.R
import com.hoopers.theuniversityfinder.fragment.CourseDescriptionFragment
import com.hoopers.theuniversityfinder.fragment.CoursesFragment

class HomeActivity : AppCompatActivity() {

    lateinit var myNavigationView: BottomNavigationView
    lateinit var frameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        myNavigationView = findViewById(R.id.myNavigation)
        frameLayout = findViewById(R.id.frameLayout)

        myNavigationView.itemIconTintList = null

        supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.fadein,R.anim.fadeout).replace(R.id.frameLayout,
            FeaturedFragment()
        ).commit()

        myNavigationView.setOnNavigationItemSelectedListener {

            when(it.itemId){

                R.id.nav_featured -> {
                    supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.fadein,R.anim.fadeout).replace(R.id.frameLayout,
                        FeaturedFragment()
                    ).commit()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_profile -> {
                    supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.fadein,R.anim.fadeout).replace(R.id.frameLayout,
                        CoursesFragment()
                    ).commit()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_courses -> {
                    supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.fadein,R.anim.fadeout).replace(R.id.frameLayout,
                        CoursesFragment()
                    ).commit()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_huddle -> {

                }

                R.id.nav_saved -> {

                }


            }
            false
        }
    }

    override fun onBackPressed() {

        val frag = supportFragmentManager.findFragmentById(R.id.frameLayout)

        when(frag){

            is CourseDescriptionFragment -> {
                supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.fadein,R.anim.fadeout).replace(R.id.frameLayout,
                    CoursesFragment()
                ).commit()
            }
            !is FeaturedFragment -> {
                supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.fadein,R.anim.fadeout).replace(R.id.frameLayout,
                    FeaturedFragment()
                ).commit()
            }
            else -> {
                super.onBackPressed()
            }

        }
    }
}
