package com.cred.assignment.ui.main

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.cred.assignment.R
import com.cred.assignment.event.SongItemClickEvent
import com.cred.assignment.ui.base.BaseEventActivity
import com.cred.assignment.ui.player.PlayerFragment
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class MainActivity : BaseEventActivity() {
    private lateinit var toolBar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolBar = findViewById(R.id.toolBar)

        setUpToolBar()
        addFragment(MainFragment(), false)
    }

    private fun setUpToolBar() {
        setSupportActionBar(toolBar)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onSongItemClickEvent(event: SongItemClickEvent) {
        addFragment(PlayerFragment.newInstance(event.song))
    }

    private fun addFragment(fragment: Fragment, isBackStack: Boolean = true) {
        val builder = supportFragmentManager.beginTransaction()
            .add(R.id.container, fragment)
        if (isBackStack) {
            builder.addToBackStack(null)
        }
        builder.commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}
