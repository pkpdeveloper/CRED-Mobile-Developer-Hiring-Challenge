package com.cred.assignment.di.main

import com.cred.assignment.ui.main.MainActivity
import com.cred.assignment.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [MainActivityModule::class, MainFragmentModule::class])
abstract class ContributeMainModule {

    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector()
    abstract fun contributeMainFragment(): MainFragment
}