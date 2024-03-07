package com.starfly.myfinalsubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class GameAdapter(private val listGame: ArrayList<Games>) : RecyclerView.Adapter<GameAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.imgPhoto)
        val tvTitle: TextView = itemView.findViewById(R.id.txtTitle)
        val tvDesc: TextView = itemView.findViewById(R.id.txtOverview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_game_row, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listGame.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, description, photo) = listGame[position]
        Glide.with(holder.itemView.context).load(photo).into(holder.imgPhoto)
        holder.tvTitle.text = title
        holder.tvDesc.text = description

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailGames::class.java)
            intentDetail.putExtra("game_key", listGame[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}