package com.example.handybook_construction_android_app.ui.showroom_details

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.ui.book_an_appointment_activity.BookAnAppointmentActivity
import com.example.handybook_construction_android_app.ui.book_details.ReviewAdapter

class ShowroomDetailsActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var imagePagerAdapter: ImagePagerAdapter
    private lateinit var adapter: ReviewAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonRequest: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showroom_details)

        val back: ImageView = findViewById(R.id.ivShowRoomDetailsBack)
        back.setOnClickListener {
            finish()
        }
        buttonRequest = findViewById(R.id.btnShowRoomRequestAQuote)
        buttonRequest.setOnClickListener {
         startActivity(Intent(this,BookAnAppointmentActivity::class.java))
        }

        viewPager = findViewById(R.id.headerImage)
        val imageList: List<Int> = listOf(
            R.drawable.furniture_image,
            R.drawable.building_background,
            R.drawable.event_image,
            R.drawable.furniture_image,
            R.drawable.building_background,
            R.drawable.event_image,
            R.drawable.furniture_image,
            R.drawable.building_background,
        )
        recyclerView = findViewById(R.id.rvShowRoomDetailsVerticalReviews)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ReviewAdapter()
        recyclerView.adapter = adapter
        imagePagerAdapter = ImagePagerAdapter(this, imageList)
        viewPager.adapter = imagePagerAdapter

    }
}