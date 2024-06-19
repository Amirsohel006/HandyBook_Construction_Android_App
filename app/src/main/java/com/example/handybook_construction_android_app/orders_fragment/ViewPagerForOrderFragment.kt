package com.example.handybook_construction_android_app.orders_fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.handybook_construction_android_app.filter_fragment.Category_Fragment_For_Tab
import com.example.handybook_construction_android_app.filter_fragment.Location_Fragment

class ViewPagerForOrderFragment(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val fragments: List<Fragment> = listOf(
       Active_Fragment(),
        CompletedFragment(),
        CancelledFragment()
    )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}