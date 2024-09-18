package co.init.tindom

import android.app.Application
import co.init.tindom.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Session : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@Session)
            modules(appModule)
        }
    }
}