package com.sbilogan.werewolfmoderator.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.sbilogan.werewolfmoderator.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), StartGameFragment.StartGameFragmentListener {
    override fun onStartGame() {
        showPlayerList()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                showStartGame()
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

        showStartGame()
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

    companion object {
        val TAG = MainActivity::class.java.simpleName
        private const val TAG_START_GAME_FRAGMENT = "StartGameFragment"
        private const val TAG_PLAYER_LIST_FRAGMENT = "PlayerListFragment"
    }
}
