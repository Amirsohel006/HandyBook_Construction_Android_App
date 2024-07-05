package com.example.handybook_construction_android_app.ui.eventsfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R


class EventFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event, container, false).apply {
            val recyclerView: RecyclerView = findViewById(R.id.recyclerview_for_upcoming_events)
            recyclerView.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
            recyclerView.adapter = EventAdapter()


            // Attach LinearSnapHelper
            val snapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(recyclerView)
        }
    }

}