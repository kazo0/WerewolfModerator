package com.sbilogan.werewolfmoderator.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sbilogan.werewolfmoderator.R
import com.sbilogan.werewolfmoderator.model.Game

class GameListAdapter(var games: List<Game>) : RecyclerView.Adapter<GameListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.game_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.gameName.text = games[position].id?.toString() ?: "Game"
    }

    fun setGameList(games: List<Game>) {
        this.games = games
        this.notifyDataSetChanged()
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val gameName: TextView = v.findViewById(R.id.game_title)
    }
}