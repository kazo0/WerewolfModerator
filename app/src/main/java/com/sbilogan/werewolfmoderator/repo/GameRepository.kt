package com.sbilogan.werewolfmoderator.repo

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import com.sbilogan.werewolfmoderator.db.GameDao
import com.sbilogan.werewolfmoderator.model.Game
import com.sbilogan.werewolfmoderator.model.Player
import kotlinx.coroutines.experimental.*

class GameRepository(private var gameDao: GameDao) {

    fun getAllGames() : LiveData<List<Game>> {
        return gameDao.loadGames()
    }

    fun getGame(gameId: Long, callback: (Game?) -> Unit) {
        GlobalScope.launch {
            val game = gameDao.loadGame(gameId)

            game?.id?.let { game.players = gameDao.loadPlayersStatic(it) }

            launch(Dispatchers.Main) {
                callback(game)
            }
        }
    }

    fun getPlayers(gameId: Long) : LiveData<List<Player>> {
        return gameDao.loadPlayers(gameId)
    }

    fun createGame(game: Game) {
        GlobalScope.launch {
            gameDao.addGame(game)
        }

    }

    fun addPlayer(gameId: Long, player: Player) {
        GlobalScope.launch {
            player.gameId = gameId
            gameDao.addPlayer(player)
        }
    }


}