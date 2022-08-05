package com.example.assessment.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assessment.R

class MainActivity : AppCompatActivity() {

    val apiKey = "j0XjaRWTD643A1dfnomojk6ijDpn3NAO"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(
            R.id.fragmentContainerView,
            ItemFragment.getInstance()
        ).commit()
    }
}