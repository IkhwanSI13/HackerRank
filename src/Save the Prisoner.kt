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

//https://www.hackerrank.com/challenges/save-the-prisoner/problem?isFullScreen=true
//Example
//n=4
//m=6
//s=2
//There are 4 prisoners, 6 pieces of candy and distribution starts at chair 2. The prisoners arrange themselves in seats numbered 1 to 4. Prisoners receive candy at positions 2, 3, 4, 1, 2, 3. The prisoner to be warned sits in chair number 3.
//Sample Input 1
//2
//7 19 2
//3 7 3
//Sample Output 1
//6
//3

/*
 * Complete the 'saveThePrisoner' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n = prisoner
 *  2. INTEGER m = candy
 *  3. INTEGER s = seat
 */

fun saveThePrisoner(n: Int, m: Int, s: Int): Int {
    // Write your code here
    var candy:Int
    if(m>=n) candy = m%n else candy = m
    
    var result = candy + s - 1
    if(result==0) return n
    if(result>n) return result - n
    return result
}

// TIME LIMIT ISSUE
// fun saveThePrisoner(n: Int, m: Int, s: Int): Int {
//     // Write your code here
//     var candy:Int = m;
//     var currentSeat:Int = s;
//     while(candy>0){
//         candy--;
//         if(candy!=0)
//             if(currentSeat<n){
//                 currentSeat++;
//             }else if(currentSeat == n){
//                 currentSeat=1;
//             }
//     }
//     return currentSeat;
// }

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val n = first_multiple_input[0].toInt()

        val m = first_multiple_input[1].toInt()

        val s = first_multiple_input[2].toInt()

        val result = saveThePrisoner(n, m, s)

        println(result)
    }
}
