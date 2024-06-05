package com.example.handybook_construction_android_app.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.otpactivity.OTPActivity
import com.example.handybook_construction_android_app.signupactivity.SignUpActivity

class LoginScreenActivity : AppCompatActivity() {

    private lateinit var loginButton:AppCompatButton
    private lateinit var signUptxt:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        loginButton=findViewById(R.id.loginButton)
        signUptxt=findViewById(R.id.signuptxt)
        loginButton.setOnClickListener {
            val i=Intent(this,OTPActivity::class.java)
            startActivity(i)
        }

        signUptxt.setOnClickListener {
            val i=Intent(this,SignUpActivity::class.java)
            startActivity(i)
        }
    }
}