package com.dicoding.kitasehatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val tvDataNameReceived : TextView = findViewById(R.id.my_name)
        val tvDataImgReceived : ImageView = findViewById(R.id.img_alfandidan)
        val tvDataDescriptionReceived : TextView = findViewById(R.id.email)


        tvDataNameReceived.text = getString(R.string.about_name)
        tvDataDescriptionReceived.text = getString(R.string.email)
        tvDataImgReceived.setImageResource(R.drawable.about_photo)
    }
}