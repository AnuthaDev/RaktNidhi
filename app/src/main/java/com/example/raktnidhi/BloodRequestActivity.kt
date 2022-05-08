package com.example.raktnidhi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BloodRequestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blood_request)

        val checkavailbtn = findViewById<Button>(R.id.checkavailbtn)

        checkavailbtn.setOnClickListener {
            val intent = Intent(this, BloodAvailabilityActivity::class.java)
            startActivity(intent)
        }
    }
}