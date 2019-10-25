package com.cred.assignment.ui.main

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.cred.assignment.R
import dagger.android.support.DaggerAppCompatActivity


class MainActivity : DaggerAppCompatActivity() {
    private lateinit var toolBar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolBar = findViewById(R.id.toolBar)

        setUpToolBar()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()
    }

    private fun setUpToolBar() {
        setSupportActionBar(toolBar)
    }


}
