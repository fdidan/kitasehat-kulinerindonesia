package com.dicoding.kitasehatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvfoods: RecyclerView
    private val list = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?, ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvfoods = findViewById(R.id.rv_foods)
        rvfoods.setHasFixedSize(true)

        list.addAll(getListFoods())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_about -> {
                val intentToAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intentToAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListFoods(): ArrayList<Food>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listFood = ArrayList<Food>()
        for (i in dataName.indices){
            val food = Food(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listFood.add(food)
        }
        return listFood
    }

    private fun showRecyclerList(){
        rvfoods.layoutManager = LinearLayoutManager(this)
        val listFoodAdapter = ListFoodAdapter(list)
        rvfoods.adapter = listFoodAdapter

        listFoodAdapter.setOnItemCallBack(object : ListFoodAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Food) {
                val intentToDetail = Intent(this@MainActivity, DetailFoodActivity::class.java)
                intentToDetail.putExtra("key_food", data)
                startActivity(intentToDetail)
            }
        })
    }

}