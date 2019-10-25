package com.cred.assignment.presenter.main

import com.cred.assignment.view.main.MainView
import com.cred.assignment.network.ApiService


interface MainPresenter {
    fun setView(mainView: MainView)
    fun loadData(apiService: ApiService)
}