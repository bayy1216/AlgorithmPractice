package sliver

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){


    val N = readLine().toInt() // BufferedReader로 사용자 입력 받기
    val pos = readLine().split(" ").map{ it.toInt() }
    if(N == 1){
        println("권병장님, 중대장님이 찾으십니다")
        return
    }
    val range = readLine().split(" ").map{ it.toInt() }

    var canGoMaxPos = 0
    for(i in 0..<N-1){
        val canGo = pos[i] + range[i]

        if(canGo > canGoMaxPos){
            canGoMaxPos = canGo
        }
        if(canGoMaxPos < pos[i+1]){
            println("엄마 나 전역 늦어질 것 같아")
            return
        }

    }
    println("권병장님, 중대장님이 찾으십니다")
}
