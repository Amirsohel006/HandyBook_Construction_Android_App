package com.example.handybook_construction_android_app.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface

fun Activity.AlertDialogForActivity(
    message: String,
    positiveButtonText: String,
    positiveButtonClick : () -> Unit = {},
    negativeButtonText: String
) {

    AlertDialog.Builder(this)
        .setMessage(message)
        .setCancelable(false)
        .setPositiveButton(positiveButtonText) { _, _ -> positiveButtonClick() }
        .setNegativeButton(negativeButtonText, null)
        .create()
        .show()
}