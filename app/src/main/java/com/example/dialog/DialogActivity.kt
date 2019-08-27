package com.example.dialog

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import com.google.android.material.snackbar.Snackbar

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.text.SimpleDateFormat
import java.util.*

class DialogActivity : AppCompatActivity() {

    var TAG= "DialogActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        simpleDialog.setOnClickListener { view ->
            Snackbar.make(view, "Sample Dialog box", Snackbar.LENGTH_LONG).show();
            var simpleDialogFragment = SimpleDialogFragment();
            simpleDialogFragment.isCancelable = false;
            simpleDialogFragment.show(supportFragmentManager, "SimpleDialogFragment");

        }

        choiceDialog.setOnClickListener { view ->
            Snackbar.make(view, "Choice Dialog box", Snackbar.LENGTH_LONG).show();
            var singleChoiceDialogFragment = SingleChoiceDialogFragment();
            singleChoiceDialogFragment.isCancelable = false;
            singleChoiceDialogFragment.show(supportFragmentManager, "SingleChoiceDialogFragment");
        }

        var cal = Calendar.getInstance()
        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

        }
        datePickerButton.setOnClickListener { view ->
            Snackbar.make(view, "Date Dialog box", Snackbar.LENGTH_LONG).show();
            var datePickerDialog = DatePickerDialog(this, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH));
            Log.i(TAG, String.format("Date Chosen : Day :%d, Month:%d, Year:%d",cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.MONTH),cal.get(Calendar.YEAR)));

            datePickerDialog.setTitle("Choose Date");
            datePickerDialog.show();
        }

        customDialog.setOnClickListener { view ->
            Snackbar.make(view, "Custom Dialog box", Snackbar.LENGTH_LONG).show();
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
