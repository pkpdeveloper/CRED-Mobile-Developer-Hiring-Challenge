package com.cred.assignment.di.player

import com.cred.assignment.ui.player.PlayerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [PlayerFragmentModule::class])
abstract class ContributePlayerModule {

    @ContributesAndroidInjector()
    abstract fun contributePlayerFragment(): PlayerFragment
}