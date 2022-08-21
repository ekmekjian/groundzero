import okhttp3.OkHttpClient;
import java.math.BigInteger
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset

fun main(){
    val matrixAsString = """
            89 1903   3
            18    3   1
             9    4 800
            """.trimIndent()
    val stringSplitbyNl = matrixAsString.split("\n")
    val matrixAsSingle = "1"
   // println(Matrix(matrixAsString).column(2))
    for(row in stringSplitbyNl){
       println(row.replace("\\s+".toRegex()," ").trim().split(" "))
     //  println(row.replace("\\s+".toRegex()," ").split(" ").map { it.toInt() }[1])
    }
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
class Matrix(private val matrixAsString: String) {
    private val rows = matrixAsString.split("\n")
    fun column(colNr: Int): List<Int> {
        val colNum = colNr - 1
        val answer = mutableListOf<Int>()
        for (row in rows){
            answer.add(row.replace("\\s+".toRegex()," ").trim().split(" ").map { it.toInt() }[colNum])
        }
        return answer
    }

    fun row(rowNr: Int): List<Int> {
        val answer = rows[rowNr-1].split(" ").map{ it.toInt()}
        return answer
    }
}
