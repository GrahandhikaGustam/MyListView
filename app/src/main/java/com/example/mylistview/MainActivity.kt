package com.example.mylistview

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper.prepare
import android.os.ParcelFileDescriptor
import android.provider.ContactsContract
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: Actor_Worldwar2Adapter
    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var Actor_WorldWar2 = arrayListOf<Actor_WorldWar2>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView:ListView = findViewById(R.id.lv_list)
        adapter = Actor_Worldwar2Adapter(this)
        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener{_, _, position, _ ->
            Toast.makeText(this@MainActivity, Actor_WorldWar2[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }
    private fun addItem() {
        for (position in dataName.indices){
            val actorworldwar2 = Actor_WorldWar2(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDescription[position]
            )
            Actor_WorldWar2.add(actorworldwar2)
        }
        adapter.Actor_WorldWar2 = Actor_WorldWar2
    }
}

