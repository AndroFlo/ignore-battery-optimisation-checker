package com.androflo.ignorebatteryoptimisationcheckerapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.github.androflo.ignorebatteryoptimisationchecker.IgnoreBatteryOptimisationChecker

class MainActivity : AppCompatActivity() {

    lateinit var buttonCheck: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCheck = findViewById(R.id.buttonCheck)

        buttonCheck.setOnClickListener {

            IgnoreBatteryOptimisationChecker(this)
                .check()

        }
    }
}
