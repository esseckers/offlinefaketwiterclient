package com.esseckers.test.app.offlinefaketwiterclient.model.interactor.user

import com.esseckers.test.app.offlinefaketwiterclient.model.repository.user.UserRepository

/**
 * Created by Ivan Danilov.
 */
class UserInteractor constructor(
    private val userRepository: UserRepository
) {
    fun getUser(name: String) = userRepository.getUser(name)
}