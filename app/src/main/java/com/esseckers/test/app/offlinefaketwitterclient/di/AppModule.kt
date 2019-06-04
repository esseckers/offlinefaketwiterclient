package com.esseckers.test.app.offlinefaketwitterclient.di

import com.esseckers.test.app.offlinefaketwitterclient.di.provider.DatabaseProvider
import com.esseckers.test.app.offlinefaketwitterclient.di.provider.TweetDataDaoProvider
import com.esseckers.test.app.offlinefaketwitterclient.di.provider.UserDataDaoProvider
import com.esseckers.test.app.offlinefaketwitterclient.model.interactor.splash.SplashInteractor
import com.esseckers.test.app.offlinefaketwitterclient.model.interactor.twits.TweetsInteractor
import com.esseckers.test.app.offlinefaketwitterclient.model.interactor.user.UserInteractor
import com.esseckers.test.app.offlinefaketwitterclient.model.repository.twits.TweetsRepository
import com.esseckers.test.app.offlinefaketwitterclient.model.repository.user.UserRepository
import com.esseckers.test.app.offlinefaketwitterclient.presentation.login.LoginPresenter
import com.esseckers.test.app.offlinefaketwitterclient.presentation.splash.SplashPresenter
import com.esseckers.test.app.offlinefaketwitterclient.presentation.twits.TweetsPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder

/**
 * Created by Ivan Danilov.
 */

/**
 * AppModule need for provide injects for base components of application:
 * - navigation
 * - database
 */
val appModule = module {
    //Navigation
    val cicerone = Cicerone.create()
    single { cicerone.router }
    single<NavigatorHolder> { cicerone.navigatorHolder }
    //Database
    single { DatabaseProvider(androidContext()).get() }
}

/**
 * DatabaseModule need for provide injects dao components
 * for use CRUD(CREATE,READ,UPDATE,DELETE) operations
 *
 */
val databaseModule = module {
    factory { (TweetDataDaoProvider(get()).get()) }
    factory { (UserDataDaoProvider(get()).get()) }
}

/**
 * RepositoryModule need for provide injects Repository components
 * for work with database data
 *
 */
val repositoryModule = module {
    factory { TweetsRepository(get()) }
    factory { UserRepository(get()) }
}

/**
 * InteractorModule need for provide injects Interactors components
 * for prepare data for user interface
 *
 */
val interactorModule = module {
    factory { TweetsInteractor(get(), get()) }
    factory { UserInteractor(get()) }
    factory { SplashInteractor(get(), get()) }
}

/**
 * PresenterModule need for provide injects Presenters components
 * for deliver data to user interface
 *
 */
val presenterModule = module {
    factory { SplashPresenter(get()) }
    factory { LoginPresenter(get()) }
    factory { TweetsPresenter(get()) }
}
