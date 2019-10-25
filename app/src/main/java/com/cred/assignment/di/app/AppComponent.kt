package com.cred.assignment.di.app

import com.cred.assignment.di.main.ContributeMainModule
import com.cred.assignment.ui.main.MainApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector


@Component(modules = [AppModule::class, ContributeMainModule::class, AndroidInjectionModule::class])
interface AppComponent : AndroidInjector<MainApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MainApplication>()

}