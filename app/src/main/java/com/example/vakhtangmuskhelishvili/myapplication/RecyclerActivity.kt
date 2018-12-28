package com.example.vakhtangmuskhelishvili.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.vakhtangmuskhelishvili.myapplication.RecyclerView.Adapter
import com.google.firebase.database.*

class RecyclerActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    lateinit var ref: DatabaseReference
    val myDataset = ArrayList<Hotel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)


        viewManager = LinearLayoutManager(this) as RecyclerView.LayoutManager
        viewAdapter = Adapter(myDataset)

        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            setHasFixedSize(true)

            layoutManager = viewManager
            adapter = viewAdapter

            val hotel = Hotel("https://t-ec.bstatic.com/images/hotel/max1024x768/109/109935852.jpg","Ramada Encore Tbilisi", "GEL 224", "15 Alexander Kazbegi Ave, T'bilisi 0160•0322 44 11 11")
            myDataset.add(hotel)
            ref = FirebaseDatabase.getInstance().getReference("Hotels")
            val childEventListener = object : ChildEventListener {
                override fun onCancelled(p0: DatabaseError) {
                }

                override fun onChildMoved(p0: DataSnapshot, p1: String?) {
                }

                override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                }

                override fun onChildRemoved(p0: DataSnapshot) {
                }

                override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
                    val map = dataSnapshot.value as Map<String, String>
                    val hotel=Hotel(map["webAdd"].toString(),map["HotelName"].toString(),map["Price"].toString(),map["Address"].toString())
                    myDataset.add(hotel)

                }


            }
            ref.addChildEventListener(childEventListener)


        }


    }

}