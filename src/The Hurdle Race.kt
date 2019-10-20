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

// Complete the hurdleRace function below.
fun hurdleRace(naturalJump: Int, height: Array<Int>): Int {
    var top = 0
    for (value in height) {
        if (top < value)
            top = value
    }
    if (naturalJump<top)
        return top-naturalJump
    return 0
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val height = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = hurdleRace(k, height)

    println(result)
}
