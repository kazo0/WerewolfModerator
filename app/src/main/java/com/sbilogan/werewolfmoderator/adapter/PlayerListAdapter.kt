package com.sbilogan.werewolfmoderator.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sbilogan.werewolfmoderator.R

class PlayerListAdapter(private var playerList: List<String>) :
        RecyclerView.Adapter<PlayerListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.player_item, parent, false))
    }

    override fun getItemCount(): Int {
       return playerList.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.playerName.text = playerList[position]

    }

    fun setPlayersList(players: List<String>) {
        playerList = players
        this.notifyDataSetChanged()
    }

    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
        val playerName: TextView = v.findViewById(R.id.player_name)
    }
}