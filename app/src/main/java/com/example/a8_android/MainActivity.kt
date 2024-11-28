package com.example.a8_android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var beerArrayList: ArrayList<BeerDataClass>
    private lateinit var imageIds: Array<Int>
    private lateinit var titles: Array<String>
    private lateinit var descriptions: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.newRecycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        imageIds = arrayOf(R.drawable.beer1, R.drawable.beer2, R.drawable.beer3)
        titles = resources.getStringArray(R.array.beer_titles)
        descriptions = resources.getStringArray(R.array.beer_descriptions)
        beerArrayList = arrayListOf()
        getBeerData()
        recyclerView.adapter = BeerAdapter(beerArrayList)
    }
    private fun getBeerData() {
        for (i in imageIds.indices) {
            val beer = BeerDataClass(imageIds[i], titles[i], descriptions[i])
            beerArrayList.add(beer)
        }
    }
}