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

// b1 14
// b2 16
// b3 13
// c1 14
// c2 14
// c3 15 A
// d1 15 A
// d2 13

// 4 9 2
// 3 5 7
// 8 1 6

// CLUE
// GOOGLING SEMUA KEMUNGKINAN DAN TINGGAL DICOCOKIIN

// https://www.youtube.com/watch?v=zPnN046OM34
// SETIAP JUMLAH BARIS / KOLOM / DIAGONAL AKAN SELALU 15
// LIST JUMLAH 3 ANGKA YANG 15
// BUAT DITENGAH, CARI ANGKA YANG 4 KALI MUNCUL DARI LIST SEBELUMNYA
// TIAP SUDUT, CARI ANGKA YANG MUNCUL 3 KALI
// SISANYA DITENGAH"

//https://www.hackerrank.com/challenges/magic-square-forming/

fun formingMagicSquare(s: Array<Array<Int>>): Int {
    var finalOutput = arrayListOf<Int>()
    var listOption = arrayListOf(
        arrayListOf(arrayListOf(8, 1, 6), arrayListOf(3, 5, 7), arrayListOf(4, 9, 2)),
        arrayListOf(arrayListOf(8, 3, 4), arrayListOf(1, 5, 9), arrayListOf(6, 7, 2)),
        arrayListOf(arrayListOf(2, 7, 6), arrayListOf(9, 5, 1), arrayListOf(4, 3, 8)),
        arrayListOf(arrayListOf(2, 9, 4), arrayListOf(7, 5, 3), arrayListOf(6, 1, 8)),
        arrayListOf(arrayListOf(6, 1, 8), arrayListOf(7, 5, 3), arrayListOf(2, 9, 4)),
        arrayListOf(arrayListOf(6, 7, 2), arrayListOf(1, 5, 9), arrayListOf(8, 3, 4)),
        arrayListOf(arrayListOf(4, 3, 8), arrayListOf(9, 5, 1), arrayListOf(2, 7, 6)),
        arrayListOf(arrayListOf(4, 9, 2), arrayListOf(3, 5, 7), arrayListOf(8, 1, 6))
    )

    for (currentOption in listOption) {
        var output = 0
        for (x in 0..2) {
            for (y in 0..2) {
                if (currentOption[x][y] != s[x][y])
                    output += (abs(currentOption[x][y] - s[x][y]))
            }
        }
        finalOutput.add(output)
    }

    return finalOutput.min()!!
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = Array<Array<Int>>(3, { Array<Int>(3, { 0 }) })

    for (i in 0 until 3) {
        s[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = formingMagicSquare(s)

    println(result)
}
