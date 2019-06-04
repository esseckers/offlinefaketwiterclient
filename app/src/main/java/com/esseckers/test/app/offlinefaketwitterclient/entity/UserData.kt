package com.esseckers.test.app.offlinefaketwitterclient.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Ivan Danilov.
 */
/**
 * Database table entity
 */
@Entity(tableName = "userData")
data class UserData(
    @PrimaryKey @ColumnInfo(name = "user_id") var userId: Long?,
    @ColumnInfo(name = "user_name") var userName: String
)