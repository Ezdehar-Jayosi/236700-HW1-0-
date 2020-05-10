package Storage

import Utils.Conversion
import Utils.peerStorage
import com.google.inject.Inject
import com.google.inject.Singleton
import il.ac.technion.cs.softwaredesign.storage.SecureStorage

@Singleton
class PeerStorage @Inject constructor(
    @peerStorage private val peerStorage: SecureStorage
) : Peer {
    override fun addPeers(infohash: String, peerData: List<Any>) {
        peerStorage.write(infohash.toByteArray(), Conversion.toByteArray(peerData) as ByteArray)
    }

    override fun getPeers(infohash: String): List<Any>? {
        val peers = peerStorage.read(infohash.toByteArray())
        if (peers == null) return null
        return Conversion.fromByteArray(peers) as List<Any>
    }

    override fun invalidatePeer(infohash: String, peerId: String) {
        TODO("Not yet implemented")
    }
}