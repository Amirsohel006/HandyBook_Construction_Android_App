package com.example.handybook_construction_android_app.ui.filterActivity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.ui.filter_fragment.ViewPagerAdapterForFilter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class FiltersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter2)

        val viewPager = findViewById<ViewPager2>(R.id.viewPagerFilters)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayoutFilters)
        val backImageView = findViewById<ImageView>(R.id.ivFiltersBack)

        backImageView.setOnClickListener{
            finish()
        }

        val viewPagerAdapter = ViewPagerAdapterForFilter(this)
        viewPager.adapter = viewPagerAdapter

        val tabTitles = listOf("Brand","Rating","Categories")

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

    }
}