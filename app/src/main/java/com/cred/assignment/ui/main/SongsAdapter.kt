package com.cred.assignment.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cred.assignment.R
import com.cred.assignment.network.response.Song

class SongsAdapter : RecyclerView.Adapter<SongsAdapter.ProductHolder>() {
    private var songsList: List<Song>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        return ProductHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_song_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return songsList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val song = songsList?.get(position)
        song?.let {
            holder.tvTitle.text = it.song
            holder.tvArtists.text = it.artists
            Glide.with(holder.ivThumb)
                .load(it.cover_image)
                .centerCrop()
                .into(holder.ivThumb)
        }
    }

    fun setData(songsList: List<Song>) {
        this.songsList = songsList
        notifyDataSetChanged()
    }

    inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        internal val tvArtists = itemView.findViewById<TextView>(R.id.tvArtists)
        internal val ivThumb = itemView.findViewById<ImageView>(R.id.ivThumb)
    }
}