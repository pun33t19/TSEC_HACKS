package com.example.tsechacksapp.ui


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.tsechacksapp.*
import com.example.tsechacksapp.adapters.RecyclerTopicAdapter
import com.google.android.material.tabs.TabLayout


class HomeFragment : Fragment() {
    lateinit var viewPager1: ViewPager
    lateinit var tabLayout1: TabLayout
    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager : RecyclerView.LayoutManager

    val dsaList = arrayListOf(
        "Stack",
        "Queue",
        "Linked List",
        "Tree",
        "Graph",
        "Bubble Sort",
        "Quick Sort"
    )


    lateinit var recyclerAdapter : RecyclerTopicAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?



    ): View? {
<<<<<<< HEAD
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
=======

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.recyclerTopics)
        layoutManager = GridLayoutManager(activity as Context,2,GridLayoutManager.VERTICAL,false)
        recyclerAdapter = RecyclerTopicAdapter(activity as Context, dsaList)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = layoutManager
        return view
>>>>>>> 53ccf2171c0e3bec627daeb1d9118e87507483e8
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}



