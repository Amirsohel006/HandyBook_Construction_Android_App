package com.example.handybook_construction_android_app.ui.professional_fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.ui.filter_category_fragment.Filter_Category_Activity
import com.example.handybook_construction_android_app.ui.filter_fragment.FilterActivity
import com.example.handybook_construction_android_app.ui.location_fragment.CompleteLocationActivity
import com.example.handybook_construction_android_app.ui.proffesionaldetailsfragment.ProffessionalsDetailsFragment


class ProfessionalFragment : Fragment(),ProfessionalAdapter.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_professional, container, false).apply {
            val recyclerView: RecyclerView = findViewById(R.id.recyclerviewforprofessionals)
            recyclerView.layoutManager = GridLayoutManager(requireActivity(), 2)
            recyclerView.adapter = ProfessionalAdapter(this@ProfessionalFragment)


            // Attach LinearSnapHelper
            val snapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(recyclerView)

            val filter_layout=findViewById<RelativeLayout>(R.id.filter_id)
             filter_layout.setOnClickListener {
                 val i=Intent(requireActivity(), FilterActivity::class.java)
                 startActivity(i)
             }


            val location_layout=findViewById<RelativeLayout>(R.id.location_id)
            location_layout.setOnClickListener {
                val i=Intent(requireActivity(), CompleteLocationActivity::class.java)
                startActivity(i)
            }

            val category_layout=findViewById<RelativeLayout>(R.id.professional_id)
            category_layout.setOnClickListener {
                val i=Intent(requireActivity(), Filter_Category_Activity::class.java)
                startActivity(i)
            }
        }
    }

    override fun onItemClick(position: Int) {
        startActivity(Intent(requireActivity(),ProffessionalsDetailsFragment::class.java))
    }


}