package com.esseckers.test.app.offlinefaketwiterclient.model.repository.user

import com.esseckers.test.app.offlinefaketwiterclient.model.SchedulersProvider
import com.esseckers.test.app.offlinefaketwiterclient.model.database.UserDataDao

/**
 * Created by Ivan Danilov.
 */
class UserRepository constructor(
    private val userDataDao: UserDataDao,
    private val schedulers: SchedulersProvider
) {
    fun getUser(name: String) = userDataDao
        .getUserByName(name)
        .subscribeOn(schedulers.io())
        .observeOn(schedulers.ui())
}