package Storage

interface Torrent {
    fun addTorrent(infohash:String,torrentData:Any)
    fun getTorrentData(infohash:String):Any?
    fun updateAnnounceList(infohash:String,announceList:List<List<Any>>)
}