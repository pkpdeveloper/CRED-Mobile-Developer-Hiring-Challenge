package com.cred.assignment.ui.main

import androidx.multidex.MultiDex
import com.cred.assignment.di.app.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


class MainApplication : DaggerApplication() {
    private val appComponent: AndroidInjector<MainApplication> by lazy {
        DaggerAppComponent
            .builder()
            .create(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
    }

}