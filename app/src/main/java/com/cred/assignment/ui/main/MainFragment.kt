package com.cred.assignment.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cred.assignment.R
import com.cred.assignment.event.SongItemClickEvent
import com.cred.assignment.network.ApiService
import com.cred.assignment.network.response.Song
import com.cred.assignment.presenter.main.MainPresenter
import com.cred.assignment.ui.base.BaseEventFragment
import com.cred.assignment.view.main.MainView
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject


class MainFragment : BaseEventFragment(), MainView, SongsAdapter.OnItemClickListener {
    private lateinit var recycleView: RecyclerView
    private lateinit var emptyTextView: TextView
    private lateinit var loadingView: View
    @Inject
    internal lateinit var apiService: ApiService
    @Inject
    internal lateinit var presenter: MainPresenter
    @Inject
    internal lateinit var songsAdapter: SongsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycleView = view.findViewById(R.id.recycleView)
        emptyTextView = view.findViewById(R.id.emptyTextView)
        loadingView = view.findViewById(R.id.loadingView)
        recycleView.apply {
            layoutManager = GridLayoutManager(this.context, 2)
            adapter = songsAdapter
        }
        presenter.setView(this)
        songsAdapter.setOnItemClickListener(this)
        presenter.loadData(apiService)

    }

    override fun showProgress() {
        loadingView.visibility = View.VISIBLE
    }

    override fun hindProgress() {
        loadingView.visibility = View.GONE
    }

    override fun displayData(songsList: List<Song>) {
        songsAdapter.setData(songsList)
    }

    override fun onError() {
        emptyTextView.visibility = View.VISIBLE
        emptyTextView.text = getString(R.string.load_data_error)
    }

    override fun onItemClicked(song: Song) {
        EventBus.getDefault().post(SongItemClickEvent(song))
    }
}