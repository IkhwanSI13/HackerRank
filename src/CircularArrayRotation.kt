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

//https://www.hackerrank.com/challenges/circular-array-rotation/
//Example
// a = [3,4,5]
// k = 2
// queries = [1,2]
//Here k is the number of rotations on a, and queries holds the list of indices to report. First we perform the two rotations:
//[3,4,5] -> [5,3,4] -> [4,5,3]
//Now return the values from the zero-based indices  and  as indicated in the  array.
//a[1] = 5
//a[2] = 3

/*
 * Complete the 'circularArrayRotation' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY a
 *  2. INTEGER k
 *  3. INTEGER_ARRAY queries
 */

fun circularArrayRotation(a: Array<Int>, k: Int, queries: Array<Int>): Array<Int> {
    // Write your code here
    if (k == a.size || (k != 1 && a.size % k == 0))
        return (queries.map { num -> a[num] }).toTypedArray()

    var result = a.toMutableList()
    var step = k
    if(k > a.size)
        step = k % a.size
    while(step>0){
        val store = result[a.size - 1]
        result.removeAt(a.size - 1)
        result.add(0, store)
        step--
    }
    return (queries.map { num -> result[num] }).toTypedArray()

}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val k = first_multiple_input[1].toInt()

    val q = first_multiple_input[2].toInt()

    val a = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val queries = Array<Int>(q, { 0 })
    for (i in 0 until q) {
        val queriesItem = readLine()!!.trim().toInt()
        queries[i] = queriesItem
    }

//    val result = circularArrayRotation(a, k, queries)

//    println(result.joinToString("\n"))
}
