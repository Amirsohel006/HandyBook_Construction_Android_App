package com.example.handybook_construction_android_app.otpactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.homecontainer.HomeContainer

class OTPActivity : AppCompatActivity() {

    private lateinit var verifyButton:AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otpactivity)

        verifyButton=findViewById(R.id.verifyButton)
        verifyButton.setOnClickListener {
            val i=Intent(this,HomeContainer::class.java)
            startActivity(i)
        }
    }
}