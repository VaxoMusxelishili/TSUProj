package com.example.vakhtangmuskhelishvili.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_pay.*

class PayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)
        onCash()
        onCard()
    }
    private fun onCash(){
        cash.setOnClickListener(){
            val intent= Intent(this,RecyclerActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Chosen hotel has been notified, redirecting to hotels list",
                Toast.LENGTH_SHORT).show()
        }
    }
    private fun onCard(){
        card.setOnClickListener(){
            val intent= Intent(this,CardActivity::class.java)
            startActivity(intent)
        }
    }
}
