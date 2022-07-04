import okhttp3.OkHttpClient;
import java.math.BigInteger
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset

fun main(){
    println(Hamming.compute("GGACTGAAATCTG", "GGACTGAAATCTG"))
}
object Hamming {
    var difference = 0
    fun compute(leftStrand: String, rightStrand: String): Int {
        inputCheck(leftStrand,rightStrand)
        if(leftStrand == "")
            return 0
        val leftArray = leftStrand.toCharArray()
        val rightArray = rightStrand.toCharArray()
        for (i in leftArray.indices) {
            if (leftArray[i] != rightArray[i])
                difference++
        }
        return difference
    }
    fun inputCheck(strand1: String, strand2: String){
        if(strand1.length != strand2.length)
            throw IllegalArgumentException("left and right strands must be of equal length")
    }
}
class Gigasecond (val inputDate: LocalDateTime?){
    var inputToseconds: Long = 0

    constructor(inputDate: LocalDate) : this(inputDate.atStartOfDay())

    var date: LocalDateTime = inputDate?.plusSeconds(1000000000) ?: LocalDateTime.now()


}
