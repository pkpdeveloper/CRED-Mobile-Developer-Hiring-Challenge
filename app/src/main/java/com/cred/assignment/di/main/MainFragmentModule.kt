package com.cred.assignment.di.main

import com.cred.assignment.presenter.main.MainPresenter
import com.cred.assignment.presenter.main.MainPresenterImpl
import com.cred.assignment.ui.main.SongsAdapter
import dagger.Module
import dagger.Provides

@Module
object MainFragmentModule {

    @JvmStatic
    @Provides
    fun provideSongsAdapter(): SongsAdapter {
        return SongsAdapter()
    }

    @JvmStatic
    @Provides
    fun provideMainPresenter(): MainPresenter {
        return MainPresenterImpl()
    }

}