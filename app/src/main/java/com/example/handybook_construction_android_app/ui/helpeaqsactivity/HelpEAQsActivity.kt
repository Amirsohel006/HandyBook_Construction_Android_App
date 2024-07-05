package com.example.handybook_construction_android_app.ui.helpeaqsactivity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R

class HelpEAQsActivity : AppCompatActivity(){
    lateinit var adapter: HelpEAQsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_eaqs)
        val backImageView = findViewById<ImageView>(R.id.ivHelpEaqsBack)
        backImageView.setOnClickListener {
            finish()
        }






        adapter=HelpEAQsAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.rvFrequentlyAskedQuestions)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, (recyclerView.layoutManager as LinearLayoutManager).orientation))
        recyclerView.adapter=adapter

    }


}