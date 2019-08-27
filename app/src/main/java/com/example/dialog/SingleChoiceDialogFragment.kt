package com.example.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class SingleChoiceDialogFragment : DialogFragment() {

    var TAG ="SingleChoiceDialogFragment";
    var colors = arrayOf("RED","WHITE","BLUE","GREEN","ORANGE");


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var alertDialogBuilder = AlertDialog.Builder(activity);

        alertDialogBuilder.setTitle("What is your favorite color");
        alertDialogBuilder.setItems(colors,DialogInterface.OnClickListener { dialogInterface, i ->

            Log.i(TAG, String.format("Color chosen ==> %s",colors[i]));
        })


        return alertDialogBuilder.create();
    }

    override fun onCancel(dialog: DialogInterface?) {
        super.onCancel(dialog);
    }


}