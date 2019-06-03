package com.esseckers.test.app.offlinefaketwiterclient.model.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.esseckers.test.app.offlinefaketwiterclient.entity.UserData
import io.reactivex.Single


/**
 * Created by Ivan Danilov.
 */
@Dao
interface UserDataDao {
    @Query("SELECT * from userData  WHERE user_name = :name ")
    fun getUserByName(name: String): Single<UserData>

    @Insert(onConflict = REPLACE)
    fun insert(user: UserData): Single<Long>

    @Query("DELETE from userData")
    fun deleteUser(): Single<Void>
}