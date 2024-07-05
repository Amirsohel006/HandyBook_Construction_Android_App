package com.example.handybook_construction_android_app.ui.favoriteacitivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.ui.professional_fragment.ProfessionalAdapter

class FavoriteActivity : AppCompatActivity(), FavoriteAdapter.OnClickListener {
    lateinit var adapter: FavoriteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        adapter = FavoriteAdapter(this)
        val recyclerView = findViewById<RecyclerView>(R.id.rv_favorite)
        recyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(position: Int) {
        TODO("Not yet implemented")
    }
}