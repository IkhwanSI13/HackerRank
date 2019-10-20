import java.util.*

// Complete the climbingLeaderboard function below.
//    println("output:\n")
//    println(ranking.toString())

fun climbingLeaderboardButTimeOut(scores: Array<Int>, alice: Array<Int>): Array<Int> {
    val output = arrayListOf<Int>()
    val ranking = scores.distinct()

    for (nilai in alice) {
        if (nilai < ranking.last())
            output.add(ranking.size + 1)
        else if (nilai == ranking.last())
            output.add(ranking.size)
        else for ((index, nilaiRanking) in ranking.withIndex()) {
            if (nilai >= nilaiRanking) {
                output.add(index + 1)
                break
            }
        }
    }

    return output.toTypedArray()
}

fun climbingLeaderboard(scores: Array<Int>, alice: Array<Int>): Array<Int> {
    val output = arrayListOf<Int>()

    for (nilai in alice) {
        var pos = 1
        for ((index, nilaiRanking) in scores.withIndex()) {
            if (nilai >= nilaiRanking) {
                output.add(pos)
                break
            }
        }
    }

    return output.toTypedArray()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val scoresCount = scan.nextLine().trim().toInt()

    val scores = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val aliceCount = scan.nextLine().trim().toInt()

    val alice = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = climbingLeaderboard(scores, alice)

    println(result.joinToString("\n"))
}

//Cheat check another github
//fun main(args: Array<String>) {
//    val scan = Scanner(System.`in`)
//
//    val n = scan.nextInt()
//    val scores = Stack<Int>()
//    for (i in 0..n - 1) {
//        val score = scan.nextInt()
//        if (i == 0 || scores.peek() != score) {
//            scores.push(score)
//        }
//    }
//
//    val m = scan.nextInt()
//    for (i in 0..m - 1) {
//        val alice = scan.nextInt()
//        while (!scores.empty() && scores.peek() <= alice) {
//            scores.pop()
//        }
//        println(if (scores.isEmpty()) "1" else scores.size + 1)
//    }
//}