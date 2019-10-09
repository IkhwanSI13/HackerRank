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

//https://www.hackerrank.com/challenges/cats-and-a-mouse/problem

// Complete the catAndMouse function below.
fun catAndMouse(catA: Int, catB: Int, mouse: Int): String {
    var output = ""
    val distanceFromCatA = abs(abs(mouse) - abs(catA))
    val distanceFromCatB = abs(abs(mouse) - abs(catB))

    output = when {
        distanceFromCatA < distanceFromCatB -> "Cat A"
        distanceFromCatA > distanceFromCatB -> "Cat B"
        else -> "Mouse C"
    }

    return output
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val xyz = scan.nextLine().split(" ")

        val x = xyz[0].trim().toInt()

        val y = xyz[1].trim().toInt()

        val z = xyz[2].trim().toInt()

        val result = catAndMouse(x, y, z)

        println(result)
    }
}
