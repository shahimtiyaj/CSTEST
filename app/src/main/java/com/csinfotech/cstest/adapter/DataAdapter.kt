package com.csinfotech.cstest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.csinfotech.cstest.model.DataInfo
import com.csinfotech.cstest.R

class DataAdapter(mContext: Context, itemList: List<DataInfo>) :
    RecyclerView.Adapter<DataAdapter.MyViewHolder>() {
    private var mContext: Context
    private val dInfoList: List<DataInfo>

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView
        var des: TextView
        var date: TextView

        init {
            mContext = itemView.context
            title = view.findViewById(R.id.txtTitle)
            des = view.findViewById(R.id.txtDes)
            date = view.findViewById(R.id.txtDate)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

            val dataInfo: DataInfo = dInfoList[position]
            holder.title.setText(dataInfo.title)
            holder.des.setText(dataInfo.des)
            holder.date.setText(dataInfo.date)
    }

    override fun getItemCount(): Int {
        return dInfoList.size
    }

    init {
        this.mContext = mContext
        dInfoList = itemList
    }
}
