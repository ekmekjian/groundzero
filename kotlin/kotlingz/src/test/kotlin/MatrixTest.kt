import kotlin.test.Test
import kotlin.test.assertEquals

class MatrixTest{
    @Test
fun `extract column from one number matrix`() {
    val matrixAsString = "1"
    val columnIndex = 1
    val expectedColumn = listOf(1)
    kotlin.test.assertEquals(expectedColumn, Matrix(matrixAsString).column(columnIndex))
}
    @Test
    fun `extract column matrix`() {
        val matrixAsString = """
            1 2 3
            4 5 6
            7 8 9
            """.trimIndent()
        val columnIndex = 3
        val expectedColumn = listOf(3, 6, 9)
        assertEquals(expectedColumn, Matrix(matrixAsString).column(columnIndex))
    }

    @Test
    fun `extract column from non square matrix`() {
        val matrixAsString = """
            1 2 3 4
            5 6 7 8
            9 8 7 6
            """.trimIndent()
        val columnIndex = 4
        val expectedColumn = listOf(4, 8, 6)
        assertEquals(expectedColumn, Matrix(matrixAsString).column(columnIndex))
    }

    @Test
    fun `extract column from diff widths matrix`() {
        val matrixAsString = """
            89 1903   3
            18    3   1
             9    4 800
            """.trimIndent()
        val columnIndex = 2
        val expectedColumn = listOf(1903, 3, 4)
        assertEquals(expectedColumn, Matrix(matrixAsString).column(columnIndex))
    }
}