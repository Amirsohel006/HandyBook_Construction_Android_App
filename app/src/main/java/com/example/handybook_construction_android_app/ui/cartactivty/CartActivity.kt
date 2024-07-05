package com.example.handybook_construction_android_app.ui.cartactivty

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R

class CartActivity : AppCompatActivity() {
    lateinit var adapter: CartAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        adapter = CartAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.rvCartOrder)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        val toolbarText = findViewById<TextView>(R.id.tvToolbarTitleCart)
        toolbarText.text = "${adapter.itemCount} items In Cart"
    }

}