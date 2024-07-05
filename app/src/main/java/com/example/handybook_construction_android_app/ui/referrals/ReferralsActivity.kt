package com.example.handybook_construction_android_app.ui.referrals

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.handybook_construction_android_app.R

class ReferralsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_referrals)

        val backImageView = findViewById<ImageView>(R.id.ivReferralBack)
        backImageView.setOnClickListener {
            finish()
        }

    }
}