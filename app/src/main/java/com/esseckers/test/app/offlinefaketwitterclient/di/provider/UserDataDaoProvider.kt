package com.esseckers.test.app.offlinefaketwitterclient.di.provider

import com.esseckers.test.app.offlinefaketwitterclient.model.database.TweetsDatabase
import com.esseckers.test.app.offlinefaketwitterclient.model.database.UserDataDao

/**
 * Created by Ivan Danilov.
 */
/**
 * UserDataDaoProvider need for data access object(DAO) for table UserData
 *
 * @param database need for provide dao
 */
class UserDataDaoProvider constructor(private val database: TweetsDatabase) {
    /**
     * Return instance of UserDataDao
     */
    fun get(): UserDataDao = database.userDataDao()
}