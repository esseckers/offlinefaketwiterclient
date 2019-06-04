package com.esseckers.test.app.offlinefaketwitterclient.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.esseckers.test.app.offlinefaketwitterclient.entity.UserData
import io.reactivex.Completable
import io.reactivex.Single


/**
 * Created by Ivan Danilov.
 */
/**
 * UserDataDao for implement CRUD(CREATE,READ,UPDATE,DELETE)
 * operations with database on table UserData
 */
@Dao
interface UserDataDao {
    /**
     * Fetch all users  from userData table
     */
    @Query("SELECT * from userData ")
    fun getUsers(): Single<List<UserData>>

    /**
     * Save user to DB when he login
     *
     * @param user
     */
    @Insert(onConflict = REPLACE)
    fun insert(user: UserData): Completable

    /**
     * Delete user from DB when he logout
     */
    @Query("DELETE from userData")
    fun deleteUser(): Completable
}