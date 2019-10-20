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
import kotlin.math.abs
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'pickingNumbers' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY a as parameter.
 */

// https://www.hackerrank.com/challenges/picking-numbers
// Sample Input 0
// 6
//  4 6 5 3 3 1
//
// Sample Output 0
// 3
// 3 karena output hasil arraynya adalah  4, 3, dan 3.
// karena angka tersebut yang bisa menghasil pengurangan kecil sama dari 1

fun pickingNumbers(a: Array<Int>): Int {
    // Write your code here
    var options = arrayListOf<ArrayList<Int>>()
    for (data in a) {
        options.add(arrayListOf(data))
    }

    for ((index, value) in options.withIndex()) {
        for ((index2, value2) in a.withIndex()) {
            if (index == index2) {
                continue
            } else {
                var find = arrayListOf<Boolean>()
                for (data in value) {
                    if (abs(data - value2) == 1 || data - value2 == 0) {
                        find.add(true)
                    } else {
                        find.add(false)
                    }
                }
                if (!find.contains(false)) {
                    value.add(value2)
                }
            }
        }
    }

    var max = 0
    for (data in options) {
        if (max < data.size)
            max = data.size
    }
//    println("output:\n")
//    println(options.toString())

    return max
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val a = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = pickingNumbers(a)

    println(result)
}
