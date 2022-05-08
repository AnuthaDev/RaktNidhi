package com.example.raktnidhi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.android.material.card.MaterialCardView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class HomeActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        mAuth = FirebaseAuth.getInstance();

        val user = mAuth.currentUser
        val nametxt = findViewById<TextView>(R.id.nametxtview)
        val bgtxt = findViewById<TextView>(R.id.bloodgrptxtview)
        Firebase.database.getReference("users/" + user!!.uid).get()
            .addOnSuccessListener { result ->
                val data: HashMap<String, String> =
                    result.value as HashMap<String, String>
                nametxt.text = "Welcome, " + data["name"]
                bgtxt.text = "Blood Group: " + data["bloodgroup"]
                //Log.d("raktnidhi", data["name"].toString())
            }
        val bloodreqbtn = findViewById<MaterialCardView>(R.id.reqblood)

        val viewdonorid = findViewById<MaterialCardView>(R.id.donoridview)

        val nearbyreqbtn = findViewById<MaterialCardView>(R.id.nearbyreqs)

        nearbyreqbtn.setOnClickListener {
            val intent = Intent(this, NearbyReqActivity::class.java)
            startActivity(intent)
        }
        bloodreqbtn.setOnClickListener {
            val intent = Intent(this, BloodRequestActivity::class.java)
            startActivity(intent)
        }

        viewdonorid.setOnClickListener {
            val intent = Intent(this, DonorIDActivity::class.java)
            startActivity(intent)
        }

    }
}