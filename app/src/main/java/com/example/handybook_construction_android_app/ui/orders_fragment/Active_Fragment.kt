package com.example.handybook_construction_android_app.ui.orders_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.handybook_construction_android_app.R
import com.google.android.material.tabs.TabLayout


class Active_Fragment : Fragment() {


    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null
    lateinit var adapter: ActiveOrderAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_active_, container, false).apply {
            tabLayout = findViewById(R.id.tabLayout)
            viewPager = findViewById(R.id.viewPager)
//
//            viewPager.adapter = ViewPagerAdapter(supp)
//            tabLayout.setupWithViewPager(viewPager)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewActive)
        adapter = ActiveOrderAdapter()
        recyclerView.layoutManager=LinearLayoutManager(requireContext())
        recyclerView.adapter=adapter



    }



}