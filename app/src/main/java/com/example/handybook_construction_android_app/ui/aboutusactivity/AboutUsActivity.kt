package com.example.handybook_construction_android_app.ui.aboutusactivity

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.handybook_construction_android_app.R

class AboutUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        val imageView = findViewById<ImageView>(R.id.iv_aboutUs)
        val darkColorFilter=PorterDuffColorFilter(Color.argb(150,0,0,0),PorterDuff.Mode.DARKEN)
        imageView.colorFilter = darkColorFilter

        val backImageView = findViewById<ImageView>(R.id.ivAboutUsBack)
        backImageView.setOnClickListener {
            finish()
        }

    }

}