package com.cred.assignment.view.main

import com.cred.assignment.network.response.Song

interface MainView {
    fun showProgress()
    fun hindProgress()
    fun displayData(songsList: List<Song>)
    fun onError()
}