package com.cred.assignment.ui.base

import dagger.android.support.DaggerAppCompatActivity
import org.greenrobot.eventbus.EventBus

open class BaseEventActivity : DaggerAppCompatActivity() {

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
}