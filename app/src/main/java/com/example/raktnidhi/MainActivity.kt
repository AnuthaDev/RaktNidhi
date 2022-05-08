package com.example.raktnidhi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance();

        val user = mAuth.currentUser
        if (user != null) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        val emailtxt = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val passwordtxt = findViewById<EditText>(R.id.editTextTextPassword)
        var nametxt = findViewById<EditText>(R.id.nametxt)
        var bloodgrouptxt = findViewById<EditText>(R.id.bloodgrouptxt)

        val registerbtn = findViewById<Button>(R.id.registerbtn)
        val loginbtn = findViewById<Button>(R.id.loginbtn)




        registerbtn.setOnClickListener {
            createAccount(
                name = nametxt.text.toString(),
                bloodgroup = bloodgrouptxt.text.toString(),
                email = emailtxt.text.toString(),
                password = passwordtxt.text.toString()
            )
        }
        loginbtn.setOnClickListener {
            loginAccount(emailtxt.text.toString(), passwordtxt.text.toString())
        }

    }

    override fun onStart() {
        super.onStart()

        var currentUser = mAuth.currentUser;
        updateUI(currentUser)
    }

    private fun createAccount(name: String, bloodgroup: String, email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(
                this
            ) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("raktnidhi", "createUserWithEmail:success")
                    Toast.makeText(
                        this@MainActivity, "Account created succesfully",
                        Toast.LENGTH_LONG
                    ).show()
                    val user = mAuth.currentUser;

                    val userdata = hashMapOf(
                        "name" to name,
                        "bloodgroup" to bloodgroup,
                    )
                    Firebase.database.getReference("users/" + user!!.uid).setValue(userdata)
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("raktnidhi", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        this@MainActivity, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)
                }

                // ...
            }
    }

    fun loginAccount(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(
                this
            ) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("raktnidhi", "signInWithEmail:success")
                    val user = mAuth.currentUser
                    Firebase.database.getReference("users/" + user!!.uid).get()
                        .addOnSuccessListener { result ->
                            val intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)
                            finish()
//                            val data: HashMap<String, String> =
//                                result.value as HashMap<String, String>
//                            Log.d("raktnidhi", data["first"].toString())


                        }
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("raktnidhi", "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        this@MainActivity, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)
                }

                // ...
            }
    }

    private fun updateUI(currentUser: FirebaseUser?) {
        //TODO
    }
}