import java.io.*
import java.math.*
import java.text.*
import java.util.*
import java.util.regex.*

/*
 * Complete the pageCount function below.
 */

//https://www.hackerrank.com/challenges/drawing-book/problem?isFullScreen=true
//Brie’s Drawing teacher asks her class to open their books to a page number. Brie can either start turning pages from the front of the book or from the back of the book. She always turns pages one at a time. When she opens the book, page  is always on the right side:
//When she flips page 1, she sees pages 2 and 3. Each page except the last page will always be printed on both sides. The last page may only be printed on the front, given the length of the book. If the book is  pages long, and she wants to turn to page , what is the minimum number of pages she will turn? She can start at the beginning or the end of the book.
//Given n and p, find and print the minimum number of pages Brie must turn in order to arrive at page p.
//
//Function Description
//Complete the pageCount function in the editor below. It should return the minimum number of pages Brie must turn.
//
//pageCount has the following parameter(s):
//n: the number of pages in the book
//p: the page number to turn to
//
//Input Format
//The first line contains an integer n, the number of pages in the book.
//The second line contains an integer, p, the page that Brie's teacher wants her to turn to
//
//Output Format
//Print an integer denoting the minimum number of pages Brie must turn to get to page p.

fun pageCount(numberOfPage: Int, pageDestination: Int): Int {
    var countFromFront = 0
    var countFromBack = 0

    var find = false
    var changeCount = false

    for (x in 0..numberOfPage step 2) {
        //print("value:" + x)
        var y = x
        if (y == pageDestination || (y + 1) == pageDestination) {
            changeCount = true
            find = true
        }

        if (changeCount) {
            if (find)
                find = !find
            else
                countFromBack++
        } else
            countFromFront++
    }

    if (countFromFront > countFromBack)
        return countFromBack
    return countFromFront
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val p = scan.nextLine().trim().toInt()

    val result = pageCount(n, p)

    println(result)
}
