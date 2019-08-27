package com.example.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class SimpleDialogFragment extends DialogFragment {

    private final String TAG="SimpleDialogFragment";

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder alertDialog =new AlertDialog.Builder(getActivity());

        alertDialog.setTitle("Simple Dialog Tittle");
        alertDialog.setMessage("Do you want to Continue");
        alertDialog.setNeutralButton("Not Sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.i(TAG, "Neutral Button");
            }
        });
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.i(TAG,"YES Button Clicked");

            }
        });
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.i(TAG, "NO Button clicked");
            }
        });

        return alertDialog.create();
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.i(TAG, "CANCELLED");
    }
}
