package com.example.handybook_construction_android_app.ui.address.add_address

import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.handybook_construction_android_app.R

class AddAddressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_address)
        onBackClick()

    }

    private fun onBackClick() {
        val back:ImageView=findViewById(R.id.ivAddAddressBack)
        back.setOnClickListener {
            finish()
        }
    }
}