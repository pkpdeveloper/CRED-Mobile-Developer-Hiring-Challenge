package com.cred.assignment.presenter.player

import com.cred.assignment.view.main.PlayerView
import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.MediaSource


class PlayerPresenterImpl : PlayerPresenter, Player.EventListener {
    private lateinit var playerView: PlayerView

    init {
        initializePlayer()
    }

    private fun initializePlayer() {

    }

    override fun setView(playerView: PlayerView) {
        this.playerView = playerView
    }

    override fun setMediaSource(exoPlayer: ExoPlayer, mediaSource: MediaSource) {
        exoPlayer.prepare(mediaSource)
        exoPlayer.addListener(this)
    }

    override fun startPlaying(exoPlayer: ExoPlayer) {
        exoPlayer.playWhenReady = true
    }

    override fun stopPlaying(exoPlayer: ExoPlayer) {
        exoPlayer.stop()
    }

    override fun onPlayerError(error: ExoPlaybackException?) {
        print(error)

    }

    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        print(playWhenReady)

    }
}