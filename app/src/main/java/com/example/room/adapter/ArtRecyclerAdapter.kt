package com.example.room.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.room.R
import com.example.room.room.Model
import javax.inject.Inject

class ArtRecyclerAdapter@Inject constructor(
    val glide:RequestManager
) : RecyclerView.Adapter<ArtRecyclerAdapter.ArtViewHolder>() {

    class ArtViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    private val diffUtil=object :DiffUtil.ItemCallback<Model>(){
        override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem==newItem
        }

    }
    private val recyclerListDiffer=AsyncListDiffer(this,diffUtil)
    var models:List<Model>
        get() = recyclerListDiffer.currentList
        set(value) = recyclerListDiffer.submitList(value)

    //Recycler View'ı verimli hale getirmek ve Recycler'ı güncelleyip yeni elemanları daha hızlı koymak için



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.art_row,parent,false)
        return ArtViewHolder(view)

    }

    override fun onBindViewHolder(holder: ArtViewHolder, position: Int) {

        val imageView=holder.itemView.findViewById<ImageView>(R.id.artImageView)
        val nameText=holder.itemView.findViewById<TextView>(R.id.nameText)
        val yearText=holder.itemView.findViewById<TextView>(R.id.yearText)
        val artisNameText=holder.itemView.findViewById<TextView>(R.id.artistText)
        val art=models[position]
        holder.itemView.apply {
            nameText.text ="Name:${art.name}"
            yearText.text = "Year:${art.year}"
            artisNameText.text="Artis Name:${art.artistName}"
            glide.load(art.imageUrl).into(imageView)

        }

    }

    override fun getItemCount(): Int {
        return models.size
    }
}