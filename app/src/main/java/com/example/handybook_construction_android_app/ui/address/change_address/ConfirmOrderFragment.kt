package com.example.handybook_construction_android_app.ui.address.change_address

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.controller.change_address.OrderSummaryController
import com.example.handybook_construction_android_app.ui.cartactivty.CartAdapter

class ConfirmOrderFragment : Fragment() {
    lateinit var adapter: CartAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var buttonChoosePayment: Button
    private val orderSummaryController: OrderSummaryController? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirm_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rvCartOrder)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
        buttonChoosePayment = view.findViewById(R.id.btChoosePayment)
        buttonChoosePayment.setOnClickListener {
         orderSummaryController?.onChoosePayment()
        }
    }
}