package com.example.tsechacksapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tsechacksapp.R

class RecyclerTopicAdapter(val context: Context,val itemList : ArrayList<String> ): RecyclerView.Adapter<RecyclerTopicAdapter.TopicViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.recycler_topic_single_row,parent,false)
        return TopicViewHolder(view)

    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val text = itemList[position]
        holder.textView.text = text
    }

    override fun getItemCount(): Int {
        return itemList.size

    }
    class TopicViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textView : TextView = view.findViewById(R.id.txtRecyclerRowItem)


    }


}