/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

class Song(
    val title: String,
    val artist: String,
    val yearPublished: Int,
    val playCount: Int
) {
    fun popularity(songPlayCount: Int = playCount) {
        val isPopular: Boolean
        
        if(playCount in 0..999) {
            isPopular = false
        } else {
            isPopular = true
        }
        println("Popular artist: $isPopular. Play Count is $songPlayCount.")
    }
        
    fun bio(songTitle: String = title, songArtist: String = artist, songYearPublished: Int = yearPublished) {
        println("Song: $songTitle, performed by $songArtist, was released in $songYearPublished")
    }
}

fun main() {
    val song = Song("Gurenge","LiSA", 2019, 478098149)
    song.bio()
    song.popularity()
    /**/
}