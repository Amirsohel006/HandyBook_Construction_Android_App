package com.example.handybook_construction_android_app.ui.location_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.handybook_construction_android_app.R

class CompleteLocationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_location)
        val backImageView = findViewById<ImageView>(R.id.ivLocationBack)
        backImageView.setOnClickListener {
            finish()
        }
    }
}