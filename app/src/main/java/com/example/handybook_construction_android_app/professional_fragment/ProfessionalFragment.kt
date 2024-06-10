package com.example.handybook_construction_android_app.professional_fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.filter_category_fragment.Filter_Category_Activity
import com.example.handybook_construction_android_app.filter_fragment.FilterActivity
import com.example.handybook_construction_android_app.home_fragment.NewListingAdapter
import com.example.handybook_construction_android_app.location_fragment.CompleteLocationActivity
import kotlin.io.path.fileVisitor

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfessionalFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfessionalFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_professional, container, false).apply {
            val recyclerView: RecyclerView = findViewById(R.id.recyclerviewforprofessionals)
            recyclerView.layoutManager = GridLayoutManager(requireActivity(), 2)
            recyclerView.adapter = ProfessionalAdapter()


            // Attach LinearSnapHelper
            val snapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(recyclerView)

            val filter_layout=findViewById<RelativeLayout>(R.id.filter_id)
             filter_layout.setOnClickListener {
                 val i=Intent(requireActivity(),FilterActivity::class.java)
                 startActivity(i)
             }


            val location_layout=findViewById<RelativeLayout>(R.id.location_id)
            location_layout.setOnClickListener {
                val i=Intent(requireActivity(),CompleteLocationActivity::class.java)
                startActivity(i)
            }

            val category_layout=findViewById<RelativeLayout>(R.id.professional_id)
            category_layout.setOnClickListener {
                val i=Intent(requireActivity(),Filter_Category_Activity::class.java)
                startActivity(i)
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfessionalFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfessionalFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}