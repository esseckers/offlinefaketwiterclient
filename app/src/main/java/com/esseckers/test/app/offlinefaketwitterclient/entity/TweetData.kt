package com.esseckers.test.app.offlinefaketwitterclient.entity

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Ivan Danilov.
 */
/**
 * Database table entity
 */
@Entity(tableName = "twitData")
data class TweetData(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "img_user") @DrawableRes var imgUser: Int,
    @ColumnInfo(name = "user_name") var userName: String,
    @ColumnInfo(name = "twit_text") var twitText: String,
    @ColumnInfo(name = "img_post") @DrawableRes var imgPost: Int
)