package com.esseckers.test.app.offlinefaketwiterclient.di

import com.esseckers.test.app.offlinefaketwiterclient.di.provider.DatabaseProvider
import com.esseckers.test.app.offlinefaketwiterclient.di.provider.TwitDataDaoProvider
import com.esseckers.test.app.offlinefaketwiterclient.di.provider.UserDataDaoProvider
import com.esseckers.test.app.offlinefaketwiterclient.model.AppSchedulers
import com.esseckers.test.app.offlinefaketwiterclient.model.SchedulersProvider
import com.esseckers.test.app.offlinefaketwiterclient.model.interactor.twits.TwitsInteractor
import com.esseckers.test.app.offlinefaketwiterclient.model.interactor.user.UserInteractor
import com.esseckers.test.app.offlinefaketwiterclient.model.repository.twits.TwitsRepository
import com.esseckers.test.app.offlinefaketwiterclient.model.repository.user.UserRepository
import com.esseckers.test.app.offlinefaketwiterclient.presentation.splash.SplashPresenter
import com.esseckers.test.app.offlinefaketwiterclient.presentation.twits.TwitsPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder

/**
 * Created by Ivan Danilov.
 */
val appModule = module {
    //Navigation
    val cicerone = Cicerone.create()
    single { cicerone.router }
    single<NavigatorHolder> { cicerone.navigatorHolder }

    single { DatabaseProvider(androidContext()).get() }
    single<SchedulersProvider> { AppSchedulers() }
}

val databaseModule = module {
    factory { (TwitDataDaoProvider(get()).get()) }
    factory { (UserDataDaoProvider(get()).get()) }
}

val repositoryModule = module {
    factory { TwitsRepository(get(), get()) }
    factory { UserRepository(get(), get()) }
}

val interactorModule = module {
    factory { TwitsInteractor(get()) }
    factory { UserInteractor(get()) }
}

val presenterModule = module {
    factory { SplashPresenter(get()) }
    factory { TwitsPresenter(get()) }
}
