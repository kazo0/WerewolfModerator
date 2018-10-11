package com.sbilogan.werewolfmoderator.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.sbilogan.werewolfmoderator.R
import com.sbilogan.werewolfmoderator.adapter.PlayerListAdapter
import com.sbilogan.werewolfmoderator.model.Player
import kotlinx.android.synthetic.main.fragment_player_list.*

class PlayerListFragment : Fragment() {
    private var playerListAdapter: PlayerListAdapter? = null
    private var players = mutableListOf("Steve", "John")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_player_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupControls()
    }

    private fun setupControls() {
        players_list.layoutManager = LinearLayoutManager(requireActivity())

        playerListAdapter = PlayerListAdapter(players)
        players_list.adapter = playerListAdapter

        fab.setOnClickListener { addPlayer() }
    }

    private fun addPlayer() {
        players.add("Penny")
        playerListAdapter?.setPlayersList(players)
    }

    companion object {
        fun newInstance() = PlayerListFragment()
    }
}
