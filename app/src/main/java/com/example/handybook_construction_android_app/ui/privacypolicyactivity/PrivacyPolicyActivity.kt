package com.example.handybook_construction_android_app.ui.privacypolicyactivity

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.handybook_construction_android_app.R

class PrivacyPolicyActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy_policy)

        val imageView = findViewById<ImageView>(R.id.iv_privacy_policy)
        val darkColorFilter= PorterDuffColorFilter(Color.argb(150,0,0,0), PorterDuff.Mode.DARKEN)
        imageView.colorFilter = darkColorFilter

        val backImageView = findViewById<ImageView>(R.id.ivPrivacyPolicyBack)
        backImageView.setOnClickListener {
            finish()
        }
    }
}