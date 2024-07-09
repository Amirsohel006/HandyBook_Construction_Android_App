package com.example.handybook_construction_android_app.ui.book_an_appointment_activity

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.utils.DatePickerUtils
import java.util.Calendar

class BookAnAppointmentActivity : AppCompatActivity() {
    lateinit var dateEditText: EditText
    lateinit var back: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_an_appointment)

        dateEditText = findViewById(R.id.etDate)
        dateEditText.setOnClickListener {
            DatePickerUtils.showDatePickerDialog(this, dateEditText)
        }


    }


}