package com.esseckers.test.app.offlinefaketwiterclient.model.interactor.twits

import com.esseckers.test.app.offlinefaketwiterclient.model.repository.twits.TwitsRepository

/**
 * Created by Ivan Danilov.
 */
class TwitsInteractor constructor(
    private val twitsRepository: TwitsRepository
) {
    fun getTwits() = twitsRepository.getTwits()
}