package com.example.handybook_construction_android_app.ui.address.change_address

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.controller.change_address.PaymentController


class PaymentFragment : Fragment() {

    private val controller: PaymentController? = null
    lateinit var buttonPay:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonPay = view.findViewById(R.id.btPay)
    }


}