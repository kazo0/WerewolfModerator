package com.sbilogan.werewolfmoderator.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

@Entity
data class Game(
        @PrimaryKey(autoGenerate = true)
        var id: Long? = null,
        @Ignore
        var players: List<Player> = listOf()) {
}