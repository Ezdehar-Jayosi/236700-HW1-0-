package Storage

interface Peer {
    fun addPeers(infohash:String,peerData:List<Any>)
    fun getPeers(infohash:String):List<Any>?
    fun invalidatePeer(infohash:String,peerId:String)
}