package com.sbilogan.werewolfmoderator.model

import android.arch.persistence.room.*

@Entity
data class Player(@PrimaryKey(autoGenerate = true) var id: Long? = null,
                  @ForeignKey(entity = Game::class,
                          parentColumns = ["id"],
                          childColumns = ["gameId"],
                          onDelete = ForeignKey.CASCADE)
                  var gameId: Long? = null,
                  var name: String = "Unknown Player",
                  @Ignore
                  var type: PlayerType = PlayerType.NOT_SET,
                  var shortDescription: String = "",
                  var description: String = "") {
    enum class PlayerType {
        NOT_SET,
        VILLAGER,
        WOLF,
        WITCH
    }
}