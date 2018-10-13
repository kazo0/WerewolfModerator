package com.sbilogan.werewolfmoderator.ui


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.sbilogan.werewolfmoderator.R
import com.sbilogan.werewolfmoderator.adapter.GameListAdapter
import com.sbilogan.werewolfmoderator.viewmodel.GameViewModel
import kotlinx.android.synthetic.main.fragment_game_list.*

class GameListFragment : Fragment() {
    private lateinit var gameListAdapter: GameListAdapter
    private lateinit var gameViewModel: GameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_game_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        gameViewModel = ViewModelProviders.of(requireActivity())
                .get(GameViewModel::class.java)

        setupControls()
    }

    private fun setupControls() {

        gameListAdapter = GameListAdapter(listOf())

        games_list.setHasFixedSize(true)
        games_list.adapter = gameListAdapter
        games_list.layoutManager = LinearLayoutManager(activity)

        gameViewModel.getGames().observe(this, Observer { games -> games?.let { gameListAdapter.setGameList(it) } })

        fab.setOnClickListener {
            gameViewModel.newGame()
        }
    }

    companion object {
        fun newInstance() : GameListFragment {
            return GameListFragment()
        }
    }
}
