package com.example.tsechacksapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.example.tsechacksapp.QuizQuestionsFragment as QuizQuestionsFragment

class LoginActivity : AppCompatActivity() {

    lateinit var viewPager : ViewPager
    lateinit var tabLayout: TabLayout
    lateinit var fabGoogle : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewPager = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tab_layout)
        fabGoogle = findViewById(R.id.fab_google)

        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(LoginTabFragment(),"Login")
        adapter.addFragment(SignUpTabFragment(),"Signup")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
    class MyViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager){
        private val fragmentList : MutableList<Fragment> = ArrayList()
        private val titleList : MutableList<String> = ArrayList()
        override fun getCount(): Int {
            return fragmentList.size


        }

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        fun addFragment(fragment: Fragment,title : String){
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }



    }

}