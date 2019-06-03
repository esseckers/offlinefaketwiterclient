package com.esseckers.test.app.offlinefaketwiterclient.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Ivan Danilov.
 */
@Entity(tableName = "twitData")
data class TwitData(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "img_user") var imgUser: String,
    @ColumnInfo(name = "user_name") var userName: String,
    @ColumnInfo(name = "twit_text") var twitText: String,
    @ColumnInfo(name = "img_post") var imgPost: String

)