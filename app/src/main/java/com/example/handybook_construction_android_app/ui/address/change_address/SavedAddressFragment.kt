package com.example.handybook_construction_android_app.ui.address.change_address

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.controller.change_address.SavedAddressController
import com.example.handybook_construction_android_app.utils.updateStep


class SavedAddressFragment : Fragment(), SavedAddressAdapter.OnEditController {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: SavedAddressAdapter
    lateinit var btAddAddress: LinearLayout

    lateinit var btProceed: Button
    private val savedAddressController: SavedAddressController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved_address, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SavedAddressAdapter(this)
        recyclerView = view.findViewById(R.id.rvSavedAddress)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
        //Button Add Address
        btAddAddress = view.findViewById(R.id.btAddNewAddress)
        btAddAddress.setOnClickListener {
            Log.d("FragmentClicked","Clicked")
            savedAddressController?.onAddAddressClick()
        }

        //Button Proceed
        btProceed = view.findViewById(R.id.btSavedAddress)
        btProceed.setOnClickListener {
            Log.d("FragmentClicked","Clicked")
            savedAddressController?.onProceedClick()
        }
    }

    override fun onEditClick() {
        Log.d("FragmentClicked","Clicked")
        savedAddressController?.onSavedAddressClick()
    }


}