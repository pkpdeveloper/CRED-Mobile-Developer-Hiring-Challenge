package com.cred.assignment.ui.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cred.assignment.R
import com.cred.assignment.network.response.Song
import dagger.android.support.DaggerFragment

class PlayerFragment : DaggerFragment() {
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

        val args = arguments
        val song = args?.getParcelable<Song>("song")
        song?.let {

        }
    }
}