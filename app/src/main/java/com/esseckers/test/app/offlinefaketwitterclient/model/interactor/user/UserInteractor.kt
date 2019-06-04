package com.esseckers.test.app.offlinefaketwitterclient.model.interactor.user

import com.esseckers.test.app.offlinefaketwitterclient.entity.UserData
import com.esseckers.test.app.offlinefaketwitterclient.model.repository.user.UserRepository
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Ivan Danilov.
 */
/**
 * UserInteractor need for save user when he login
 *
 * @param userRepository
 */
class UserInteractor constructor(
    private val userRepository: UserRepository
) {
    /**
     * UserInteractor need for save user when he login
     *
     * @param user
     */
    fun saveUser(user: UserData): Completable = userRepository.saveUser(user)
}