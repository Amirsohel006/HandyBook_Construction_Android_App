package com.example.handybook_construction_android_app.ui.filter_fragment

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.handybook_construction_android_app.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class FilterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val backImageView = findViewById<ImageView>(R.id.ivFilterBack)

        backImageView.setOnClickListener{
            finish()
        }

        val viewPagerAdapter = ViewPagerAdapterForFilter(this)
        viewPager.adapter = viewPagerAdapter

        val tabTitles = listOf("Location", "Professional Category")

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
}
