package com.example.handybook_construction_android_app.ui.signupactivity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.ui.loginscreen.LoginScreenActivity

class SignUpActivity : AppCompatActivity() {

    private lateinit var loginTxt:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        loginTxt=findViewById(R.id.signuptxt)
        loginTxt.setOnClickListener {
            val i=Intent(this, LoginScreenActivity::class.java)
            startActivity(i)
        }
    }
}