package com.sbilogan.werewolfmoderator.db

import android.arch.persistence.room.*
import android.content.Context
import com.sbilogan.werewolfmoderator.model.Game
import com.sbilogan.werewolfmoderator.model.Player

@Database(entities = [Game::class, Player::class], version = 1)
abstract class WerewolfModeratorDb : RoomDatabase() {

    abstract fun gameDao(): GameDao

    companion object {
        private var instance: WerewolfModeratorDb? = null

        fun getInstance(context: Context): WerewolfModeratorDb {
            if (instance == null) {
                instance = Room
                        .databaseBuilder(context.applicationContext, WerewolfModeratorDb::class.java, "WerewolfModerator")
                        .fallbackToDestructiveMigration()
                        .build()
            }

            return instance as WerewolfModeratorDb
        }
    }
}