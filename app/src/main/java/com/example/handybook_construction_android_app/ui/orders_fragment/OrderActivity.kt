package com.example.handybook_construction_android_app.ui.orders_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.example.handybook_construction_android_app.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OrderActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val ivBack : ImageView = findViewById(R.id.ivLocationBack)
        ivBack.setOnClickListener {
            finish()
        }

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        val viewPagerAdapter= ViewPagerForOrderFragment(this)
        viewPager.adapter = viewPagerAdapter

        val tabTitles = listOf("Active", "Complete","Cancelled")

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
    }
