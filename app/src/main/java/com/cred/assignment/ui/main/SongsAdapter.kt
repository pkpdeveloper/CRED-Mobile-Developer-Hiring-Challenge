package com.cred.assignment.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.cred.assignment.R
import com.cred.assignment.network.response.Song

class SongsAdapter : RecyclerView.Adapter<SongsAdapter.ProductHolder>() {
    private var songsList: List<Song>? = null
    private var onItemClickListener: OnItemClickListener? = null
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
        songsList?.let { songsList ->
            val song = songsList[position]
            song.let {
                holder.tvTitle.text = it.song
                holder.tvArtists.text = it.artists
                Glide.with(holder.ivThumb)
                    .load(it.cover_image)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(holder.ivThumb)

                holder.itemView.setOnClickListener {
                    onItemClickListener?.onItemClicked(song, songsList)
                }
            }
        }

    }

    fun setData(songsList: List<Song>) {
        this.songsList = songsList
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        internal val tvArtists = itemView.findViewById<TextView>(R.id.tvArtists)
        internal val ivThumb = itemView.findViewById<ImageView>(R.id.ivThumb)
    }

    interface OnItemClickListener {
        fun onItemClicked(song: Song, songsList: List<Song>)
    }
}