package com.cred.assignment.di.player

import android.content.Context
import com.cred.assignment.presenter.player.PlayerPresenter
import com.cred.assignment.presenter.player.PlayerPresenterImpl
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import dagger.Module
import dagger.Provides

@Module
object PlayerFragmentModule {

    @JvmStatic
    @Provides
    fun providePlayerPresenter(): PlayerPresenter {
        return PlayerPresenterImpl()
    }

    @JvmStatic
    @Provides
    fun provideExoPlayer(context: Context): ExoPlayer {
        return ExoPlayerFactory.newSimpleInstance(
            context,
            DefaultRenderersFactory(context),
            DefaultTrackSelector(),
            DefaultLoadControl()
        )
    }
}