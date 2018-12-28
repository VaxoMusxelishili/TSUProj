package com.example.vakhtangmuskhelishvili.myapplication

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgot_pass.*

class ForgotPassActivity : AppCompatActivity() {

    val auth=FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)
        onSubmit()
    }
    private fun onSubmit(){
        submitButton.setOnClickListener(){
            auth.sendPasswordResetEmail(forgMail.text.toString()).addOnCompleteListener{
                task ->
                if(task.isSuccessful){
                    notifyText.setText("The recovery letter has been sent on your E-mail")
                    notifyText.setTextColor(Color.parseColor("#5cb85c"))
                }
            }


        }
    }
}
