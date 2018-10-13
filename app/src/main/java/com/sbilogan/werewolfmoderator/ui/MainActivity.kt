package com.sbilogan.werewolfmoderator.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.sbilogan.werewolfmoderator.R
import com.sbilogan.werewolfmoderator.db.WerewolfModeratorDb
import com.sbilogan.werewolfmoderator.model.Game
import com.sbilogan.werewolfmoderator.repo.GameRepository
import com.sbilogan.werewolfmoderator.viewmodel.GameViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), StartGameFragment.StartGameFragmentListener {
    private lateinit var gameViewModel: GameViewModel

    override fun onStartGame() {
        showPlayerList()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                showGameList()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModels()
        showGameList()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun showStartGame() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, StartGameFragment.newInstance(), TAG_START_GAME_FRAGMENT)
                .commit()
    }

    private fun showPlayerList() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, PlayerListFragment.newInstance(), TAG_PLAYER_LIST_FRAGMENT)
                .commit()
    }

    private fun showGameList() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, GameListFragment.newInstance(), TAG_GAME_LIST_FRAGMENT)
                .commit()
    }

    private fun setupViewModels() {
        gameViewModel = ViewModelProviders.of(this)
                .get(GameViewModel::class.java)

        val db = WerewolfModeratorDb.getInstance(this)
        gameViewModel.gameRepository = GameRepository(db.gameDao())
    }

    companion object {
        val TAG = MainActivity::class.java.simpleName
        private const val TAG_START_GAME_FRAGMENT = "StartGameFragment"
        private const val TAG_PLAYER_LIST_FRAGMENT = "PlayerListFragment"
        private const val TAG_GAME_LIST_FRAGMENT = "GameListFragment"
    }
}
