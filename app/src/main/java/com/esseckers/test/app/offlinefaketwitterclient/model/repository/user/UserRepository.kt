package com.esseckers.test.app.offlinefaketwitterclient.model.repository.user

import com.esseckers.test.app.offlinefaketwitterclient.entity.UserData
import com.esseckers.test.app.offlinefaketwitterclient.model.database.UserDataDao

/**
 * Created by Ivan Danilov.
 */
/**
 * UserRepository need for save, read, delete user and
 *
 * @param userDataDao
 */
class UserRepository constructor(
    private val userDataDao: UserDataDao
) {
    /**
     * Obtain users from DB
     */
    fun getUser() = userDataDao.getUsers()
    /**
     * Save user to DB
     *
     * @param user
     */
    fun saveUser(user: UserData) = userDataDao.insert(user)
    /**
     * Delete user from DB
     */
    fun deleteUser() = userDataDao.deleteUser()
}