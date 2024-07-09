package com.example.handybook_construction_android_app.ui.showroom

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.ui.filterActivity.FiltersActivity
import com.example.handybook_construction_android_app.ui.filter_fragment.FilterActivity
import com.example.handybook_construction_android_app.ui.showroom.ShowRoomAdapter.OnItemShowRoomListener
import com.example.handybook_construction_android_app.ui.showroom_details.ShowroomDetailsActivity
import org.w3c.dom.Text

class ShowroomActivity : AppCompatActivity(), OnItemShowRoomListener {
    lateinit var adapter: ShowRoomAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var filter:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showroom)
        recyclerView = findViewById(R.id.rvShowroom)
        adapter = ShowRoomAdapter(this)
        recyclerView.layoutManager = GridLayoutManager(this , 2 ,GridLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
        filter=findViewById(R.id.tvFurniture)
        val back:ImageView=findViewById(R.id.ivShowRoomBack)
        back.setOnClickListener {
            finish()
        }
        filter.setOnClickListener {
         startActivity(Intent(this, FiltersActivity::class.java))
        }
    }

    override fun onItemClick(position: Int) {
        startActivity(Intent(this, ShowroomDetailsActivity::class.java))
    }

}