package com.example.handybook_construction_android_app.utils

import android.app.DatePickerDialog
import android.content.Context
import android.widget.EditText
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object DatePickerUtils {

    fun showDatePickerDialog(context: Context, editText: EditText) {
        val calendar = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(editText, calendar)
        }

        DatePickerDialog(
            context,
            dateSetListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun updateLabel(editText: EditText, calendar: Calendar) {
        val dateFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(dateFormat, Locale.US)
        editText.setText(sdf.format(calendar.time))
    }
}
