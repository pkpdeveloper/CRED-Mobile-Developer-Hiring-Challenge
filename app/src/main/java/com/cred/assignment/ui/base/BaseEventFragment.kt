package com.cred.assignment.ui.base

import com.cred.assignment.event.SongItemClickEvent
import com.cred.assignment.ui.player.PlayerFragment
import dagger.android.support.DaggerFragment
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


open class BaseEventFragment : DaggerFragment() {

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onSongItemClickEvent(event: SongItemClickEvent) {
    }
}