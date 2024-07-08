package com.example.handybook_construction_android_app.ui.category_fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.ui.showroom.ShowroomActivity


class Category_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category_, container, false).apply {


            val recyclerView: RecyclerView = findViewById(R.id.recyclerViewFurniture)
            recyclerView.layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            recyclerView.adapter =
                com.example.handybook_construction_android_app.ui.category_fragment.FurnitureAdapter()


            // Attach LinearSnapHelper
            val snapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(recyclerView)


            val recyclerView1: RecyclerView = findViewById(R.id.recyclerViewElectronics)
            recyclerView1.layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            recyclerView1.adapter =
                com.example.handybook_construction_android_app.ui.category_fragment.ElectronicAdapter()


            // Attach LinearSnapHelper
            val snapHelper1 = LinearSnapHelper()
            snapHelper1.attachToRecyclerView(recyclerView1)


            val recyclerView2: RecyclerView = findViewById(R.id.recyclerViewFlooring)
            recyclerView2.layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            recyclerView2.adapter =
                com.example.handybook_construction_android_app.ui.category_fragment.FlooringAdapter()


            // Attach LinearSnapHelper
            val snapHelper2 = LinearSnapHelper()
            snapHelper2.attachToRecyclerView(recyclerView2)

            val recyclerView3: RecyclerView = findViewById(R.id.recyclerViewPlumbingSupplies)
            recyclerView3.layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            recyclerView3.adapter =
                com.example.handybook_construction_android_app.ui.category_fragment.plumbing_adapter()


            // Attach LinearSnapHelper
            val snapHelper3 = LinearSnapHelper()
            snapHelper3.attachToRecyclerView(recyclerView3)

            val viewAll:TextView = findViewById(R.id.tvFurnitureViewAll)
            viewAll.setOnClickListener {
                val i= Intent(requireActivity(), ShowroomActivity::class.java)
                i.putExtra("Category","Furniture")
                startActivity(i)
            }




        }
    }


}