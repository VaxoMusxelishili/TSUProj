package com.example.vakhtangmuskhelishvili.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = FirebaseAuth.getInstance()
        onRegister()
        onBack()
        onTest()
    }

    private fun onRegister(){
        regButton.setOnClickListener(){
            auth.createUserWithEmailAndPassword(mailEdittext.text.toString(), passEdittext.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        user?.sendEmailVerification()?.addOnCompleteListener{task ->
                            if(task.isSuccessful){
                                Toast.makeText(this, "Verification E-mail was sent",
                                    Toast.LENGTH_LONG).show()
                                Verif.setText("Please verify your E-mail and then login")
                            }
                        }
                    } else {
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                        Log.d("tag","prob",task.exception)
                    }

                    // ...
                }
        }
    }
    private fun onBack(){
        backBut.setOnClickListener(){
            val intent= Intent(this,FirstActivity::class.java)
            startActivity(intent)
        }
    }
    private fun onTest(){
        testButton.setOnClickListener(){
            val intent= Intent(this,PayActivity::class.java)
            startActivity(intent)
        }
    }
}
