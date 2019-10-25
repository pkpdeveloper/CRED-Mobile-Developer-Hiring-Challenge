package com.cred.assignment.presenter.player

import com.cred.assignment.network.response.Song
import com.cred.assignment.view.main.PlayerView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

interface PlayerPresenter {
    fun setView(playerView: PlayerView)
    fun setMediaSource(exoPlayer: ExoPlayer, mediaSource: MediaSource)
    fun startPlaying(exoPlayer: ExoPlayer)
    fun stopPlaying(exoPlayer: ExoPlayer)
}