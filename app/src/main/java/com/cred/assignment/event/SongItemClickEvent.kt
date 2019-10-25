package com.cred.assignment.event

import com.cred.assignment.network.response.Song

data class SongItemClickEvent(val song: Song, val songsList: List<Song>)