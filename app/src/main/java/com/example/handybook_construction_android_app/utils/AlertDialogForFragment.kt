package com.example.handybook_construction_android_app.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import androidx.fragment.app.Fragment


fun Fragment.AlertDialogForFragment(
    message: String,
    positiveButtonText: String,
    positiveButtonClick : () -> Unit = {},
    negativeButtonText: String
) {

    AlertDialog.Builder(requireContext())
        .setMessage(message)
        .setCancelable(false)
        .setPositiveButton(positiveButtonText) { _, _ -> positiveButtonClick() }
        .setNegativeButton(negativeButtonText, null)
        .create()
        .show()
}