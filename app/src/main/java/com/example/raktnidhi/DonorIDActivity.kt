package com.example.raktnidhi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class DonorIDActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor_id)

        mAuth = FirebaseAuth.getInstance();

        val user = mAuth.currentUser

        val titletext = findViewById<TextView>(R.id.titletext)

        Firebase.database.getReference("users/" + user!!.uid).get()
            .addOnSuccessListener { result ->
                val data: HashMap<String, String> =
                    result.value as HashMap<String, String>
                titletext.text = data["name"] + "'s Donor Card"
            }
    }
}