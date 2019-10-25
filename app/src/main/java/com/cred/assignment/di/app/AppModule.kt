package com.cred.assignment.di.app

import android.content.Context
import com.cred.assignment.network.ApiManager
import com.cred.assignment.network.ApiService
import com.cred.assignment.ui.main.MainApplication
import dagger.Module
import dagger.Provides
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [AndroidSupportInjectionModule::class])
object AppModule {

    @JvmStatic
    @Provides
    fun provideApiService(): ApiService {
        return ApiManager.getService()
    }

    @JvmStatic
    @Provides
    fun provideContext(application: MainApplication): Context {
        return application.applicationContext
    }

}