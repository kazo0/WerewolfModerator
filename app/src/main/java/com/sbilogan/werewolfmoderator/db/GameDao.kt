package com.sbilogan.werewolfmoderator.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.sbilogan.werewolfmoderator.model.Game
import com.sbilogan.werewolfmoderator.model.Player

@Dao
interface GameDao {
    @Query("SELECT * FROM Game")
    fun loadGames(): LiveData<List<Game>>

    @Query("SELECT * FROM Game WHERE id = :gameId")
    fun loadGame(gameId: Long) : Game?

    @Query("SELECT * FROM Player WHERE gameId = :gameId")
    fun loadPlayers(gameId: Long) : LiveData<List<Player>>

    @Query("SELECT * FROM Player WHERE gameId = :gameId")
    fun loadPlayersStatic(gameId: Long) : List<Player>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPlayer(player: Player) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addGame(game: Game) : Long

    @Delete
    fun deleteGame(game: Game)
}