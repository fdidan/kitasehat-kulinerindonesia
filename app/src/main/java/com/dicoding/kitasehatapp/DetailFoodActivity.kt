package com.dicoding.kitasehatapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager

class DetailFoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_food)

        val dataFood = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra("key_food", Food::class.java) as Food
        }else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Food>("key_food") as Food
        }

        val tvDataNameReceived : TextView = findViewById(R.id.foods_name)
        val tvDataImgReceived : ImageView = findViewById(R.id.foods_details_img)
        val tvDataDescriptionReceived : TextView = findViewById(R.id.description_details)
        val tvMoreDescriptionReceived : TextView = findViewById(R.id.more_desc)
        val tvGiziDescription : TextView = findViewById(R.id.gizi_description)

        tvDataNameReceived.text = dataFood.name
        tvDataDescriptionReceived.text = dataFood.description
        tvDataImgReceived.setImageResource(dataFood.photo)

        val dataName = resources.getStringArray(R.array.data_name)
        val moreDesc = resources.getStringArray(R.array.more_description)
        val giziDesc = resources.getStringArray(R.array.gizi)
        for (i in dataName.indices){
            if (dataFood.name == dataName[i]){
                tvMoreDescriptionReceived.text = moreDesc[i]
                tvGiziDescription.text = giziDesc[i]
            }
        }

        val descriptionTitle : TextView = findViewById(R.id.desc_title)
        val giziTitle : TextView = findViewById(R.id.gizi_title)

        descriptionTitle.text = resources.getString(R.string.desc_title)
        giziTitle.text = resources.getString(R.string.gizi_title)
    }

}

