package com.example.handybook_construction_android_app.ui.book_details

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R

class BookDetailsActivity : AppCompatActivity() {
    private lateinit var horizontalBookAdapter: HorizontalBookAdapter
    private lateinit var reviewAdapter: ReviewAdapter
    private lateinit var horizontalRecyclerView: RecyclerView
    private lateinit var reviewRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        horizontalBookAdapter = HorizontalBookAdapter()
        reviewAdapter = ReviewAdapter()

        horizontalRecyclerView = findViewById(R.id.rvHorizontalBookList)
        horizontalRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        horizontalRecyclerView.adapter = horizontalBookAdapter

        reviewRecyclerView = findViewById(R.id.rvVerticalReviews)
        reviewRecyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        reviewRecyclerView.adapter=reviewAdapter



    }
}