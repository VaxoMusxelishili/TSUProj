package com.example.vakhtangmuskhelishvili.myapplication

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        auth = FirebaseAuth.getInstance()
        onLogin()
        onForgot()
        onSignup()
        onCheck()
        val checked = PreferenceManager.getDefaultSharedPreferences(this)
            .getBoolean("checkbox", false)
        val addEmail =PreferenceManager.getDefaultSharedPreferences(this)
            .getString("mail","")
        checkbox.setChecked(checked)
        emailEdittext.setText(addEmail.toString())

    }
    private fun onLogin(){
        loginButton.setOnClickListener(){
            auth.signInWithEmailAndPassword(emailEdittext.text.toString(), passwordEdittext.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        val intent=Intent(this,RecyclerActivity::class.java)
                        startActivity(intent)
                    } else {
                        Log.d("TAG", "signInWithEmail:failure", task.exception)
                        Toast.makeText(this, "Authentication failed",
                            Toast.LENGTH_SHORT).show()

                    }

                    // ...
                }
        }
    }
    private fun onForgot(){
        forgotPassText.setOnClickListener(){
            val intent =Intent(this,ForgotPassActivity::class.java)
            startActivity(intent)

        }
    }
    private fun onSignup(){
        signUp.setOnClickListener(){
            val intent= Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    private fun onCheck(){
        checkbox.setOnClickListener(){
            if(checkbox.isChecked) {
                PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("checkbox",true).commit()
                PreferenceManager.getDefaultSharedPreferences(this).edit().putString("mail",emailEdittext.text.toString()).commit()

            }
            else  PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("checkbox",false).commit()
            PreferenceManager.getDefaultSharedPreferences(this).edit().putString("mail","").commit()
        }
    }
}
