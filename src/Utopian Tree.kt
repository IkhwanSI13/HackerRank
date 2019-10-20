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

//https://www.hackerrank.com/challenges/utopian-tree/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
// tanaman tumbuh. pertama tumbuh satu kali ke dua kali 2, dan terus bergantian

// Complete the utopianTree function below.
fun utopianTree(n: Int): Int {
    var value = 0
    var double = false
    for (x in 0..n) {
        if (!double)
            value += 1
        else
            value *= 2

        double = !double
    }

    return value
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()

        val result = utopianTree(n)

        println(result)
    }
}
