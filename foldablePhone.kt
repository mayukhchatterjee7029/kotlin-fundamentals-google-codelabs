/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }
    
    open fun switchOff() {
        isScreenLightOn = false
    }
    
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isFolded: Boolean = true): Phone() {
    override fun switchOn() {
        if(!isFolded) {
            isScreenLightOn = true
        }
    }    
    
    fun phoneFold() {
            isFolded = true
        }
    
    fun phoneUnfold() {
            isFolded = false
        }
    }

fun main() {
	val phone = FoldablePhone()
    
    phone.switchOn()
    phone.checkPhoneScreenLight()
    phone.phoneUnfold()
    phone.switchOn()
    phone.checkPhoneScreenLight()
}