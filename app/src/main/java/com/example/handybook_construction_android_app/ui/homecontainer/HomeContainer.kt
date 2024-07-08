package com.example.handybook_construction_android_app.ui.homecontainer

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.handybook_construction_android_app.ui.editprofileactivity.EditProfileActivity
import com.example.handybook_construction_android_app.controller.DrawerController
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.controller.HomeCardClickController
import com.example.handybook_construction_android_app.ui.aboutusactivity.AboutUsActivity
import com.example.handybook_construction_android_app.ui.address.change_address.ChangeAddressActivity
import com.example.handybook_construction_android_app.ui.bookstoreactivity.BookStoreFragment
import com.example.handybook_construction_android_app.ui.cartactivty.CartActivity
import com.example.handybook_construction_android_app.ui.eventsfragment.EventFragment
import com.example.handybook_construction_android_app.ui.favoriteacitivity.FavoriteActivity
import com.example.handybook_construction_android_app.ui.helpeaqsactivity.HelpEAQsActivity
import com.example.handybook_construction_android_app.ui.home_fragment.Home_Fragment
import com.example.handybook_construction_android_app.ui.orders_fragment.OrderActivity
import com.example.handybook_construction_android_app.ui.privacypolicyactivity.PrivacyPolicyActivity
import com.example.handybook_construction_android_app.ui.professional_fragment.ProfessionalFragment
import com.example.handybook_construction_android_app.ui.referrals.ReferralsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class HomeContainer : AppCompatActivity(), DrawerController,HomeCardClickController {

    private lateinit var frameBottomBar: BottomNavigationView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_container)


        drawerLayout = findViewById(R.id.drawerlayout)

        navigationView = findViewById(R.id.navigationView)
        frameBottomBar = findViewById(R.id.frameBottombar)

        navigationView.itemIconTintList = null

        replaceFragment(Home_Fragment())

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFagment) as NavHostFragment?

        val navController = navHostFragment!!.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            Log.d("NavController", "Navigated to ${destination.label}")
        }



        NavigationUI.setupWithNavController(navigationView, navController)


        NavigationUI.setupWithNavController(frameBottomBar, navController)

        val headerView = navigationView.getHeaderView(0)
        val imageView = headerView.findViewById<ImageButton>(R.id.edit_profile_image)
        imageView.setOnClickListener {  startActivity(Intent(this, EditProfileActivity::class.java))}

        frameBottomBar.setOnNavigationItemSelectedListener { it ->
            when (it.itemId) {

                R.id.home -> {
                    replaceFragment(Home_Fragment())
                    true
                }

                R.id.categotries -> {
                    replaceFragment(com.example.handybook_construction_android_app.ui.category_fragment.Category_Fragment())
                    true

                }
//
                R.id.proessionals -> {
                    replaceFragment(ProfessionalFragment())
                    true
                }
//
                R.id.events -> {
                    replaceFragment(EventFragment())
                    true
                }

                R.id.books -> {
                    replaceFragment(BookStoreFragment())
                    true
                }

                else -> {
                    TODO("Hello")
                }
            }

        }


        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_my_order -> {
                    startActivity(Intent(this, OrderActivity::class.java))
                }
                R.id.nav_about_us ->{
                    startActivity(Intent(this, AboutUsActivity::class.java))
                }
                R.id.nav_referells -> {
                    startActivity(Intent(this, ReferralsActivity::class.java))
                }
                R.id.nav_favorites -> {
                    startActivity(Intent(this, FavoriteActivity::class.java))
                }
                R.id.nav_privacy_policy -> {
                    startActivity(Intent(this, PrivacyPolicyActivity::class.java))
                }
                R.id.nav_help_and_faq -> {
                    startActivity(Intent(this, HelpEAQsActivity::class.java))
                }
                R.id.nav_my_cart -> {
                    startActivity(Intent(this, CartActivity::class.java))
                }
                R.id.nav_change_address ->{
                    startActivity(Intent(this, ChangeAddressActivity::class.java))
                }

            }

            drawerLayout.closeDrawers()
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Check if the fragment is already in the back stack
        val existingFragment = fragmentManager.findFragmentByTag(fragment.javaClass.simpleName)

        if (existingFragment == null) {
            fragmentTransaction.replace(
                R.id.navHostFagment,
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
                        is com.example.handybook_construction_android_app.ui.category_fragment.Category_Fragment -> frameBottomBar.selectedItemId =
                            R.id.categotries

                        is ProfessionalFragment -> frameBottomBar.selectedItemId = R.id.proessionals
                        is EventFragment -> frameBottomBar.selectedItemId = R.id.events
                        is BookStoreFragment -> frameBottomBar.selectedItemId =
                            R.id.books
                    }
                } ?: super.onBackPressed()
            } else {
                super.onBackPressed()
            }
        }
    }


    fun showExitDialog() {
        AlertDialog.Builder(this)
            .setMessage("Are you sure you want to exit?")
            .setCancelable(false)
            .setPositiveButton("Yes", DialogInterface.OnClickListener { _, _ -> finish() })
            .setNegativeButton("No", null)
            .show()
    }

    override fun openDrawer() {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    override fun closeDrawer() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }
    }

    override fun onProfessionalCardClick() {
        replaceFragment(ProfessionalFragment())
        frameBottomBar.selectedItemId = R.id.proessionals
    }

    override fun onBuildingMaterialsCardClick() {
        replaceFragment(com.example.handybook_construction_android_app.ui.category_fragment.Category_Fragment())
        frameBottomBar.selectedItemId = R.id.categotries
    }

}