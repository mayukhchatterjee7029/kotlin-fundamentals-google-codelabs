/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

fun main() {    
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)
    
    amanda.showProfile()
    println("")
    atiqah.showProfile()
}


class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
    	println("Name: $name\nAge: $age\nLikes to $hobby.")
        
        if(referrer == null) {
            println("Doesn't have a referrer.")
        } else {
            println("Has a referrer named Amanda, who likes to pay tennis.")
        }
        
    }
}