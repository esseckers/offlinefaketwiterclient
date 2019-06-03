package com.esseckers.test.app.offlinefaketwiterclient.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Ivan Danilov.
 */
@Entity(tableName = "userData")
data class UserData(
    @PrimaryKey @ColumnInfo(name = "user_id") var userId: Long?,
    @ColumnInfo(name = "img_user") var imgUser: String,
    @ColumnInfo(name = "user_name") var userName: String
)