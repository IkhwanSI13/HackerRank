import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the designerPdfViewer function below.
fun designerPdfViewer(h: Array<Int>, word: String): Int {
//1 search for the tallest one
//and kali
    var top = 0
    for (data in word) {
        var pos = data.toInt() - 96
        if (top < h[pos-1])
            top = h[pos-1]
    }

    return top * word.length
}

//getCharPosition()
// convert char to int and reduce with 96 for lower case
// reduce with 64 for upper case

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val h = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val word = scan.nextLine()

    val result = designerPdfViewer(h, word)

    println(result)
}
