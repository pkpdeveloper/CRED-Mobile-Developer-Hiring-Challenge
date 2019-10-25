package com.cred.assignment.di.player

import com.cred.assignment.ui.player.PlayerFragment
import com.cred.assignment.ui.player.ViewPagerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [PlayerFragmentModule::class, ViewPagerFragmentModule::class])
abstract class ContributePlayerModule {

    @ContributesAndroidInjector()
    abstract fun contributePlayerFragment(): PlayerFragment

    @ContributesAndroidInjector()
    abstract fun contributeViewPagerFragment(): ViewPagerFragment
}