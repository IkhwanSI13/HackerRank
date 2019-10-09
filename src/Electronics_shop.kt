import java.io.*
import java.math.*
import java.text.*
import java.util.*
import java.util.regex.*

//https://www.hackerrank.com/challenges/electronics-shop/

//Complete the getMoneySpent function in the editor below. It should return the maximum total price for the two items within Monica's budget, or  if she cannot afford both items.
//getMoneySpent has the following parameter(s):
//keyboards: an array of integers representing keyboard prices
//drives: an array of integers representing drive prices
//b: the units of currency in Monica's budget

//Input Format
//The first line contains three space-separated integers , , and , her budget, the number of keyboard models and the number of USB drive models.
//The second line contains  space-separated integers , the prices of each keyboard model.
//The third line contains  space-separated integers , the prices of the USB drives

//Sample Input 0
//10 2 3
//3 1
//5 2 8
//Sample Output 0
//9

fun getMoneySpent(keyboards: Array<Int>, drives: Array<Int>, b: Int): Int {
    var output = -1

    var getOutput = false
    for (data in keyboards) {
        for (data2 in drives) {
            if (b >= data + data2) {
                if (b == data + data2) {
                    output = data + data2
                    getOutput = true
                } else if (output < data + data2) {
                    output = data + data2
                }
            }
            if (getOutput)
                break
        }
        if (getOutput)
            break
    }

    return output
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val bnm = scan.nextLine().split(" ")

    val b = bnm[0].trim().toInt()

    val n = bnm[1].trim().toInt()

    val m = bnm[2].trim().toInt()

    val keyboards = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val drives = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    /*
     * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
     */

    val moneySpent = getMoneySpent(keyboards, drives, b)

    println(moneySpent)
}
