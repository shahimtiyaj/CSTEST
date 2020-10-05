package com.csinfotech.cstest.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.csinfotech.cstest.R
import com.csinfotech.cstest.adapter.DataAdapter
import com.csinfotech.cstest.model.DataInfo
import java.util.*

class MainActivity : AppCompatActivity() {
    private var cities: RecyclerView? = null
    private var adapter: RecyclerView.Adapter<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        actionBar?.hide()

        val cities: ArrayList<DataInfo> = initCities()
        this.cities = findViewById<View>(R.id.my_recycler_view) as RecyclerView
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        this.cities!!.layoutManager = mLayoutManager
        adapter = DataAdapter(this, cities)
        this.cities!!.adapter = adapter
    }

    private fun initCities(): ArrayList<DataInfo> {
        val list: ArrayList<DataInfo> = ArrayList()
        list.add(
            DataInfo(
                "Dhaka",
                "The Dhaka, the five villages in Bangladesh.",
                "06-10-2020"
            )
        )
        list.add(
            DataInfo(
                "Chittagong",
                "Chittagong is the 2nd capital city of BD",
                "07-10-2020"
            )
        )
        list.add(
            DataInfo(
                "Khulna",
                "Khulna has been one of Bangladesh most popular Division.",
                "08-10-2020"
            )
        )

        return list
    }
}