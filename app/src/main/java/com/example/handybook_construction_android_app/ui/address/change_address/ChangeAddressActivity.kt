package com.example.handybook_construction_android_app.ui.address.change_address

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.controller.change_address.OrderSummaryController
import com.example.handybook_construction_android_app.controller.change_address.PaymentController
import com.example.handybook_construction_android_app.controller.change_address.SavedAddressController
import com.example.handybook_construction_android_app.ui.address.add_address.AddAddressActivity
import com.example.handybook_construction_android_app.utils.updateStep



class ChangeAddressActivity : AppCompatActivity(), SavedAddressController, OrderSummaryController, PaymentController {

    private lateinit var firstview: View
    private lateinit var firstImageView: ImageView
    private lateinit var firstTextView: TextView

    private lateinit var secondView: View
    private lateinit var secondImageView: ImageView
    private lateinit var secondTextView: TextView

    private lateinit var thirdView: View
    private lateinit var thirdImageView: ImageView
    private lateinit var thirdTextView: TextView

    private var currentStep = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_address)
        onBackButtonClick()
        replaceFragment(SavedAddressFragment())
        initViews()
    }

    private fun initViews() {
        //First Progress Circle
        firstview = findViewById(R.id.step1_circle)
        firstImageView = findViewById(R.id.step1_image)
        firstTextView = findViewById(R.id.step1_label)

        //Second Progress Circle
        secondView = findViewById(R.id.step2_circle)
        secondImageView = findViewById(R.id.step2_image)
        secondTextView = findViewById(R.id.step2_label)

        //Third Progress Circle
        thirdView = findViewById(R.id.step3_circle)
        thirdImageView = findViewById(R.id.step3_image)
        thirdTextView = findViewById(R.id.step3_label)
    }

    private fun onBackButtonClick() {
        val back: ImageView = findViewById(R.id.ivChangeAddressBack)
        back.setOnClickListener {
            finish()
        }
    }

    override fun onSavedAddressClick() {
        Log.d("Clicked", "onProceedClick")
        startActivity(Intent(this, AddAddressActivity::class.java))
    }

    override fun onAddAddressClick() {
        Log.d("Clicked", "onProceedClick")
        startActivity(Intent(this, AddAddressActivity::class.java))
    }

    override fun onProceedClick() {
        Log.d("Clicked", "onProceedClick")
        currentStep = 2
        updateStep(
            currentStepImageView = firstImageView,
            currentStepView = firstview,
            currentStepTextView = firstTextView,
            nextStepView = secondView,
            nextStepTextView = secondTextView,
            activeColor = getColor(R.color.green_900),
            inactiveColor = getColor(R.color.white),
            setInactiveBackground = R.drawable.circle_step_completed,
            setActiveBackground = R.drawable.circle_step_active
        )
        replaceFragment(ConfirmOrderFragment())
    }

    override fun onChoosePayment() {
        currentStep = 3
        updateStep(
            currentStepImageView = secondImageView,
            currentStepView = secondView,
            currentStepTextView = secondTextView,
            nextStepView = thirdView,
            nextStepTextView = thirdTextView,
            activeColor = getColor(R.color.green_900),
            inactiveColor = getColor(R.color.white),
            setInactiveBackground = R.drawable.circle_step_completed,
            setActiveBackground = R.drawable.circle_step_active
        )
        replaceFragment(PaymentFragment())
    }

    override fun onPayClick() {
        finish()
    }

    private fun replaceFragment(fragment: Fragment) {
        Log.d("ChangeAddressActivity", "Replacing fragment with: ${fragment.javaClass.simpleName}")
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Check if the fragment is already in the back stack
        val existingFragment = fragmentManager.findFragmentByTag(fragment.javaClass.simpleName)

        if (existingFragment == null) {
            fragmentTransaction.replace(
                R.id.fcViewChangeAddress,
                fragment,
                fragment.javaClass.simpleName
            )
            fragmentTransaction.addToBackStack(fragment.javaClass.simpleName)
            fragmentTransaction.commit()
        } else {
            // If the fragment already exists, simply pop the back stack up to it
            fragmentManager.popBackStackImmediate(existingFragment.javaClass.simpleName, 0)
        }
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager

        if (fragmentManager.backStackEntryCount == 1) {
            showExitDialog()
        } else {
            if (fragmentManager.backStackEntryCount > 1) {
                fragmentManager.popBackStackImmediate()

                currentStep--
                updateStepOnBack(currentStep)

                super.onBackPressed()
            } else {
                super.onBackPressed()
            }
        }
    }

    private fun updateStepOnBack(step: Int) {
        when (step) {
            1 -> {
                updateStep(
                    currentStepImageView = firstImageView,
                    currentStepView = firstview,
                    currentStepTextView = firstTextView,
                    nextStepView = secondView,
                    nextStepTextView = secondTextView,
                    activeColor = getColor(R.color.white),
                    inactiveColor = getColor(R.color.green_900),
                    setInactiveBackground = R.drawable.circle_step_active,
                    setActiveBackground = R.drawable.circle_step_completed
                )
            }

            2 -> {
                updateStep(
                    currentStepImageView = secondImageView,
                    currentStepView = secondView,
                    currentStepTextView = secondTextView,
                    nextStepView = thirdView,
                    nextStepTextView = thirdTextView,
                    activeColor = getColor(R.color.white),
                    inactiveColor = getColor(R.color.green_900),
                    setInactiveBackground = R.drawable.circle_step_active,
                    setActiveBackground = R.drawable.circle_step_completed
                )
            }
        }
    }

    private fun showExitDialog() {
        AlertDialog.Builder(this)
            .setMessage("Are you sure you want to exit?")
            .setCancelable(false)
            .setPositiveButton("Yes") { _, _ -> finish() }
            .setNegativeButton("No", null)
            .show()
    }
}
