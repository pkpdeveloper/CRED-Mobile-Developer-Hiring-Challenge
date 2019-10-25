package com.cred.assignment.presenter.main

import com.cred.assignment.view.main.MainView
import com.cred.assignment.network.ApiService
import com.cred.assignment.network.response.Song
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainPresenterImpl : MainPresenter {
    private lateinit var view: MainView
    override fun setView(mainView: MainView) {
        this.view = mainView
    }

    override fun loadData(apiService: ApiService) {
        apiService.getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<Song>> {
                override fun onSuccess(songsList: List<Song>) {
                    view.hindProgress()
                    view.displayData(songsList)
                }

                override fun onSubscribe(d: Disposable) {
                    view.showProgress()
                }

                override fun onError(e: Throwable) {
                    view.hindProgress()
                    view.onError()
                }

            })
    }
}