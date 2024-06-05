package com.example.handybook_construction_android_app.homecontainer

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.home_fragment.Home_Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeContainer : AppCompatActivity() {

    private lateinit var frameBottomBar: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_container)

        frameBottomBar = findViewById(R.id.frameBottombar)

        replaceFragment(Home_Fragment())

        frameBottomBar.setOnNavigationItemSelectedListener {it ->
            when(it.itemId){

                R.id.home -> {
                    replaceFragment(Home_Fragment())
                    true
                }

//                R.id.attendance -> {
//                    replaceFragment(AttendanceFragment())
//                    true
//                }
//
//                R.id.report -> {
//                    replaceFragment(ReportFragment())
//                    true
//                }
//
//                R.id.account -> {
//                    replaceFragment(ProfileFragment())
//                    true
//                }

                else -> {
                    TODO("Hello")
                }
            }

        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Check if the fragment is already in the back stack
        val existingFragment = fragmentManager.findFragmentByTag(fragment.javaClass.simpleName)

        if (existingFragment == null) {
            fragmentTransaction.replace(R.id.navHostFagment, fragment, fragment.javaClass.simpleName)
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
                fragmentManager.popBackStackImmediate(
                    fragmentManager.getBackStackEntryAt(1).id,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE
                )

                var selectedFragment: Fragment? = null
                val fragments = supportFragmentManager.fragments
                for (fragment in fragments) {
                    if (fragment != null && fragment.isVisible) {
                        selectedFragment = fragment
                        break
                    }
                }

                selectedFragment?.let {
                    when (it) {
                        is Home_Fragment -> frameBottomBar.selectedItemId = R.id.home
//                        is AttendanceFragment -> frameBottomBar.selectedItemId = R.id.attendance
//                        is ReportFragment -> frameBottomBar.selectedItemId = R.id.report
//                        is ProfileFragment -> frameBottomBar.selectedItemId = R.id.account
                    }
                } ?: super.onBackPressed()
            } else {
                super.onBackPressed()
            }
        }
    }



    private fun showExitDialog() {
        AlertDialog.Builder(this)
            .setMessage("Are you sure you want to exit?")
            .setCancelable(false)
            .setPositiveButton("Yes", DialogInterface.OnClickListener { _, _ -> finish() })
            .setNegativeButton("No", null)
            .show()
    }

}