package com.example.satya.hellokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var item: MutableList<Item> = mutableListOf()

    private fun iniData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        item.clear()
        for (i in name.indices){
            item.add(Item(name[i],
            image.getResourceId(i,0)))
        }
        image.recycle()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_name.text = "Yourname"



        iniData()

        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecycleViewAdapter(this,item){
            val toast = Toast.makeText(applicationContext,it.name,Toast.LENGTH_SHORT)
            toast.show()
        }


    }
}
