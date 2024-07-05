package com.example.handybook_construction_android_app.ui.home_fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.controller.DrawerController
import com.example.handybook_construction_android_app.controller.HomeCardClickController

class Home_Fragment : Fragment() {
    private var drawerController: DrawerController? = null
    private var onItemClickListener: HomeCardClickController? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is DrawerController) {
            drawerController = context
        } else {
            throw RuntimeException("$context must implement DrawerController")
        }
        if (context is HomeCardClickController) {
            onItemClickListener = context
        } else {
            throw RuntimeException("$context must implement HomeCardClickController")
        }
    }

    override fun onDetach() {
        super.onDetach()
        drawerController = null
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_, container, false).apply {


            val recyclerView: RecyclerView = findViewById(R.id.recycle_for_listing)
            recyclerView.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            recyclerView.adapter = NewListingAdapter()


            // Attach LinearSnapHelper
            val snapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(recyclerView)


            val recyclerView1: RecyclerView = findViewById(R.id.recycler_of_top_barnd)
            recyclerView1.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            recyclerView1.adapter = TopBrandAdapter()


            // Attach LinearSnapHelper
            val snapHelper1 = LinearSnapHelper()
            snapHelper1.attachToRecyclerView(recyclerView1)

            val ivAvatar: ImageView = findViewById(R.id.ivAvatar)

            ivAvatar.setOnClickListener {
                drawerController?.openDrawer()
            }

            val cardViewProfessional = findViewById<CardView>(R.id.cvBookProfessional)
            val cardViewBuildingMaterials = findViewById<CardView>(R.id.cvBuildingMaterial)

            cardViewProfessional.setOnClickListener {
                onItemClickListener?.onProfessionalCardClick()
            }
            cardViewBuildingMaterials.setOnClickListener {
                onItemClickListener?.onBuildingMaterialsCardClick()
            }




        }
    }


}