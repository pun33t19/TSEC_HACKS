package com.example.tsechacksapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.tsechacksapp.adapters.ViewPagerAdapter
import com.example.tsechacksapp.ui.EventFragment
import com.example.tsechacksapp.ui.HomeFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter=ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(),"Home")
        adapter.addFragment(EventFragment(),"Event")

        val viewPager=findViewById<ViewPager>(R.id.view_pager)
        val tabLayout=findViewById<TabLayout>(R.id.tab_layout)

        viewPager.adapter=adapter
        tabLayout.setupWithViewPager(viewPager)
    }


}

