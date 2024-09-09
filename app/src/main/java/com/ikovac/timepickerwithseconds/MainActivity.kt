/*
 * Copyright (C) 2013 Ivan Kovac navratnanos@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ikovac.timepickerwithseconds

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.TextView
import com.ikovac.timepickerwithseconds.view.MyTimePickerDialog
import java.util.Calendar

class MainActivity : Activity() {
    private var time: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateViews()
    }

    private fun updateViews() {
        time = findViewById<View>(R.id.time) as TextView
    }

    fun showPicker(v: View?) {
        val now = Calendar.getInstance()
        val mTimePicker = MyTimePickerDialog(
            this,
            { view, hourOfDay, minute, seconds -> // TODO Auto-generated method stub
                time!!.text = getString(R.string.time) + String.format("%02d", hourOfDay) +
                        ":" + String.format("%02d", minute) +
                        ":" + String.format("%02d", seconds)
            },
            now[Calendar.HOUR_OF_DAY],
            now[Calendar.MINUTE], now[Calendar.SECOND], true
        )
        mTimePicker.show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}