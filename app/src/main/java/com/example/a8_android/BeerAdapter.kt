package com.example.a8_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class BeerAdapter(private val beerList: ArrayList<BeerDataClass>) :
    RecyclerView.Adapter<BeerAdapter.BeerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.beer_item, parent, false)
        return BeerViewHolder(itemView)
    }
    override fun getItemCount(): Int {
        return beerList.size
    }
    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        val currentItem = beerList[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.txtTitle.text = currentItem.title
        holder.txtDescription.text = currentItem.description
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Вы нажали на ${currentItem.title}", Toast.LENGTH_SHORT).show()
        }
    }
    class BeerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ShapeableImageView = itemView.findViewById(R.id.imageBeer)
        val txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
        val txtDescription: TextView = itemView.findViewById(R.id.txtDescription)
    }
}