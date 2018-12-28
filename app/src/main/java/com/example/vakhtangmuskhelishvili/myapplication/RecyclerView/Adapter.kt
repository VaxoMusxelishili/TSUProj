package com.example.vakhtangmuskhelishvili.myapplication.RecyclerView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.vakhtangmuskhelishvili.myapplication.Hotel
import com.example.vakhtangmuskhelishvili.myapplication.R
import com.squareup.picasso.Picasso

class Adapter (private val myDataset: ArrayList<Hotel>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        val inf =LayoutInflater.from(parent?.context).inflate(R.layout.item_view,parent,false)
        return MyViewHolder(inf)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hotel: Hotel=myDataset[position]

        holder.textName.text= hotel.name
        holder.textAddress.text= hotel.address
        holder.textPrice.text= hotel.price
        holder.textsec.text= hotel.name
        Picasso.get().load(hotel.webAdd).into(holder.pic)
    }

    override fun getItemCount() = myDataset.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textName: TextView=itemView.findViewById(R.id.Name)
        val textAddress: TextView=itemView.findViewById(R.id.Address)
        val textPrice: TextView=itemView.findViewById(R.id.Price)
        val textsec: TextView=itemView.findViewById(R.id.secondName)
        val pic:ImageView=itemView.findViewById(R.id.imageView)
    }


}