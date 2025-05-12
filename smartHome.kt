/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice (val name: String, val category: String) {
    
    var deviceStatus = "online"
    	protected set
    
    open val deviceType = "unknown"
    
    constructor(name: String, category:String, statusCode: Int) : this(name, category) {
    	deviceStatus = when (statusCode) {
            0 -> "Offline"
            1 -> "Online"
            else -> "Unknown"
        }
    }
    open fun turnOn() {
        deviceStatus = "on"  
    }
    
    open fun turnOff() {
        deviceStatus = "off"
    }
    open fun printDeviceInfo() {
        println("Device name: $name, Category: $category, Type: $deviceType")
    }
}

    class SmartTvDevice(deviceName: String, deviceCategory: String) :
    	SmartDevice(name = deviceName, category = deviceCategory) {
            
        override val deviceType = "Smart TV"
            
       	private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
     	private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)
        
        
        override fun printDeviceInfo() {
            println("Device name: $name, category: $category, type: $deviceType")
            }
        
        fun increaseSpeakerVolume() {
            speakerVolume++
            println{"Speaker volume increased to $speakerVolume."}
        }
        
        fun nextChannel() {
            channelNumber++
            println("Channel number increased to $channelNumber.")
        }
        
        fun previousChannel() {
            channelNumber--
            println("Channel number decreased to $channelNumber.")
        }
        override fun turnOn() {
            super.deviceStatus = "on"
            println(
                "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
            		"set to $channelNumber."
            )
        }
        override fun turnOff() {
            super.deviceStatus = "off"
            println("$name is turned off")
        }
	}
        
    class SmartLightDevice(deviceName: String, deviceCategory: String) : 
    	SmartDevice(name = deviceName, category = deviceCategory) {
            
            override val deviceType = "Smart Light"
            
            private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)
            
            override fun printDeviceInfo() {
                println("Device name: $name, category: $category, type: $deviceType")
            }
            
        	fun increaseBrightness() {
                brightnessLevel++
                println("Brightness increased to $brightnessLevel")
            }
            fun decreaseBrightness() {
                brightnessLevel--
                println("Brightness decreased to $brightnessLevel")
            }
            
           	override fun turnOn() {
                super.deviceStatus = "on"
                brightnessLevel = 2
                println("$name turned on. The brightness level is $brightnessLevel.")
            }
            
            override fun turnOff() {
                super.deviceStatus = "off"
                brightnessLevel = 0
                println("$name turned off.")
            }
        }
	
    // The SmartHome class HAS-A smart TV device
	class SmartHome(
        val smartTvDevice: SmartTvDevice,
        val smartLightDevice: SmartLightDevice
    ) {
        var deviceTurnOnCount = 0
        	private set
        
        fun turnOnTv() {
            deviceTurnOnCount++
            smartTvDevice.turnOn()
        }
        fun turnOffTv() {
            deviceTurnOnCount--
            smartTvDevice.turnOff()
        }
        fun increaseTvVolume() {
            smartTvDevice.increaseSpeakerVolume()
        }
        fun changeTvChannelToNext() {
            smartTvDevice.nextChannel()
        }
        fun changeTvChannelToPrevious() {
            smartTvDevice.previousChannel()
        }
        fun printSmartTvInfo() {
            smartTvDevice.printDeviceInfo()
        }
        
        fun turnOnLight() {
            deviceTurnOnCount++
            smartLightDevice.turnOn()
        }
        fun turnOffLight() {
            deviceTurnOnCount--
            smartLightDevice.turnOff()
        }
        fun increaseBrightness() {
            smartLightDevice.increaseBrightness()
        }
        fun decreaseBrightness() {
            smartLightDevice.decreaseBrightness()
        }
        fun turnOffAllDevices() {
            turnOffTv()
            turnOffLight()
        }
        fun printSmartLightInfo() {
            smartLightDevice.printDeviceInfo()
        }
    }

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
): ReadWriteProperty<Any?, Int> {
    
    var fieldData = initialValue
    
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }
    
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}
    
fun main() {
    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn()
    smartDevice.printDeviceInfo()
    smartDevice.changeTvChannelToNext()
    
    
    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()
    smartDevice.printDeviceInfo()
    }