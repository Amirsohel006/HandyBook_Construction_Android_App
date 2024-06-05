package com.example.handybook_construction_android_app.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView

import androidx.viewpager2.widget.ViewPager2
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.loginscreen.LoginScreenActivity

class SplashScreen : AppCompatActivity() {

    private lateinit var indicator1: ImageView
    private lateinit var indicator2: ImageView
    private lateinit var indicator3: ImageView

    private lateinit var viewPager: ViewPager2

    private lateinit var nextbutton:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

         viewPager = findViewById(R.id.viewPager)

        indicator1 = findViewById(R.id.indicator1)
        indicator2 = findViewById(R.id.indicator2)
        indicator3 = findViewById(R.id.indicator3)

        nextbutton=findViewById(R.id.next_button)
        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateIndicators(position)
            }
        })

        // Automatically move to the second page after 2 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            if (viewPager.currentItem < adapter.itemCount - 2) {
                viewPager.currentItem += 1
            }
        }, 3500)

        nextbutton.setOnClickListener {
            val i=Intent(this,LoginScreenActivity::class.java)
            startActivity(i)
        }
    }

    private fun updateIndicators(position: Int) {
        when (position) {
            0 -> {
                indicator1.setImageResource(R.drawable.circle_filled)
                indicator2.setImageResource(R.drawable.circle_empty)
                indicator3.setImageResource(R.drawable.circle_empty)
            }
            1 -> {
                indicator1.setImageResource(R.drawable.circle_empty)
                indicator2.setImageResource(R.drawable.circle_filled)
                indicator3.setImageResource(R.drawable.circle_empty)
            }
            2 -> {
                indicator1.setImageResource(R.drawable.circle_empty)
                indicator2.setImageResource(R.drawable.circle_empty)
                indicator3.setImageResource(R.drawable.circle_filled)
            }
        }
    }
}