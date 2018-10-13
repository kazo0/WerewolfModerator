package com.sbilogan.werewolfmoderator.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.sbilogan.werewolfmoderator.model.Game
import com.sbilogan.werewolfmoderator.model.Player
import com.sbilogan.werewolfmoderator.repo.GameRepository

class GameViewModel : ViewModel() {
    lateinit var gameRepository: GameRepository

    fun getGames() : LiveData<List<Game>> {
        return gameRepository.getAllGames()
    }

    fun newGame() {
        val game = Game()
        gameRepository.createGame(game)
    }

    fun getPlayers(gameId: Long) : LiveData<List<Player>> {
        return gameRepository.getPlayers(gameId)
    }
}