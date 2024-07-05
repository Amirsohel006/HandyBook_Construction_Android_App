package com.example.handybook_construction_android_app.ui.proffesionaldetailsfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R


class ProffessionalsDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_proffessionals_details, container, false).apply {
            val recyclerView: RecyclerView = findViewById(R.id.projectsRecyclerView)
            recyclerView.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            recyclerView.adapter = ProfessionalDetailsAdapter()


            // Attach LinearSnapHelper
            val snapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(recyclerView)
        }
    }

}