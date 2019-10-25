package com.cred.assignment.ui.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.cred.assignment.R
import com.cred.assignment.network.response.Song
import com.cred.assignment.ui.base.BaseEventFragment

class ViewPagerFragment : BaseEventFragment() {
    private lateinit var viewPager: ViewPager2

    companion object {
        fun newInstance(song: Song, songsList: List<Song>): ViewPagerFragment {
            val args = Bundle()
            args.putParcelable("song", song)
            args.putParcelableArray("songs_list", songsList.toTypedArray())
            val fragment = ViewPagerFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager = view.findViewById(R.id.viewPager)
        val args = arguments
        val songsList = args?.getParcelableArray("songs_list")?.toList()
        songsList?.let {
            viewPager.adapter = FragmentPagerAdapter(this, it as List<Song>)
        }

    }

    private class FragmentPagerAdapter(
        fragment: Fragment,
        private val songsList: List<Song>
    ) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int {
            return songsList.size
        }

        override fun createFragment(position: Int): Fragment {
            return PlayerFragment.newInstance(songsList[position])
        }

    }
}