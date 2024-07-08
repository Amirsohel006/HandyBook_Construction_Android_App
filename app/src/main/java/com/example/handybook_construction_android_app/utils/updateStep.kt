package com.example.handybook_construction_android_app.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.handybook_construction_android_app.R

fun updateStep(

    currentStepView: View,
    currentStepTextView: TextView,
    currentStepImageView: ImageView,
    nextStepView: View,
    nextStepTextView: TextView,
    activeColor: Int,
    inactiveColor: Int,
    setInactiveBackground:Int,
    setActiveBackground:Int,
) {
    // Hide the text of the current step and show the check mark
    currentStepTextView.visibility = View.INVISIBLE
    currentStepImageView.visibility = View.VISIBLE
    currentStepTextView.setTextColor(activeColor)
    currentStepView.setBackgroundResource(setInactiveBackground)


    // Update the background and text color of the next step
    nextStepView.setBackgroundResource(setActiveBackground)
    nextStepTextView.setTextColor(inactiveColor)
}
