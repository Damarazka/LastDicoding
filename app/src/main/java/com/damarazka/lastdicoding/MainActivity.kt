package com.damarazka.lastdicoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {
    private lateinit var rvPersons: RecyclerView
    private val list = ArrayList<Person>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPersons = findViewById(R.id.rv_people_rich)
        rvPersons.setHasFixedSize(true)

        list.addAll(getListPersons())
        showRecyclerList()
    }

    private fun getListPersons(): ArrayList<Person> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listPerson = ArrayList<Person>()
        for (i in dataName.indices) {
            val person = Person(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listPerson.add(person)
        }
        return listPerson
    }

    private fun showRecyclerList() {
        rvPersons.layoutManager = LinearLayoutManager(this)
        val listAdapter = ListAdapter(list)
        rvPersons.adapter = listAdapter
    }
}