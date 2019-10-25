package com.cred.assignment.ui.player

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cred.assignment.R
import com.cred.assignment.network.response.Song
import com.cred.assignment.presenter.player.PlayerPresenter
import com.cred.assignment.view.main.PlayerView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.util.Util
import dagger.android.support.DaggerFragment
import javax.inject.Inject


typealias ExoPlayerView = com.google.android.exoplayer2.ui.PlayerView

class PlayerFragment : DaggerFragment(), PlayerView {
    private var mediaSource: MediaSource? = null
    @Inject
    internal lateinit var presenter: PlayerPresenter

    @Inject
    internal lateinit var exoPlayer: ExoPlayer
    private lateinit var playerView: ExoPlayerView

    companion object {
        fun newInstance(song: Song): PlayerFragment {
            val args = Bundle()
            args.putParcelable("song", song)
            val fragment = PlayerFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playerView = view.findViewById(R.id.playerView)
        playerView.player = exoPlayer
        presenter.setView(this)
        val args = arguments
        val song = args?.getParcelable<Song>("song")
        song?.let {
            mediaSource = buildMediaSource(it)
        }
    }

    override fun onResume() {
        super.onResume()
        mediaSource?.let {
            presenter.setMediaSource(exoPlayer, it)
            presenter.startPlaying(exoPlayer)
        }
    }

    override fun onPause() {
        super.onPause()
        presenter.stopPlaying(exoPlayer)
    }

    private fun buildMediaSource(
        song: Song
    ): MediaSource {
        // Default parameters, except allowCrossProtocolRedirects is true
        val httpDataSourceFactory = DefaultHttpDataSourceFactory(
            Util.getUserAgent(context, "CRED"),
            null,
            DefaultHttpDataSource.DEFAULT_CONNECT_TIMEOUT_MILLIS,
            DefaultHttpDataSource.DEFAULT_READ_TIMEOUT_MILLIS,
            true /* allowCrossProtocolRedirects */
        )
        return ExtractorMediaSource.Factory(httpDataSourceFactory)
            .createMediaSource(Uri.parse(song.url))

    }
}