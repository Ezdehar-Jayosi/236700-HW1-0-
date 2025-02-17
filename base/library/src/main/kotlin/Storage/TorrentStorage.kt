package Storage
import Utils.Conversion
import Utils.torrentStorage
import com.google.inject.Singleton
import il.ac.technion.cs.softwaredesign.storage.SecureStorage
import com.google.inject.Inject

@Singleton
class TorrentStorage @Inject constructor(
    @torrentStorage private val torrentStorage: SecureStorage
) : Torrent {
    override fun addTorrent(infohash: String, torrentData: Any) {
        torrentStorage.write(infohash.toByteArray(), Conversion.toByteArray(torrentData) as ByteArray)

    }
    override fun removeTorrent(infohash:String,unloadValue:String) {
        torrentStorage.write(infohash.toByteArray(Charsets.UTF_8), unloadValue.toByteArray(Charsets.UTF_8))
    }

    override fun getTorrentData(infohash: String): ByteArray? {
        return torrentStorage.read(infohash.toByteArray())

    }

    override fun updateAnnounceList(infohash: String, announceList: List<List<Any>>) {
        TODO("Not yet implemented")
    }
}