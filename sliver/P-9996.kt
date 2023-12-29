package sliver

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){


    val N = readLine().toInt() // BufferedReader로 사용자 입력 받기
    val PATTERN = readLine()
    for (i in 0..<N){
        val target = readLine()
        if(patternMatching(PATTERN, target)){
            println("DA")
        }else{
            println("NE")
        }
    }
}


fun patternMatching(pattern: String, target: String): Boolean{

    val prefix = pattern.substring(0, pattern.indexOf("*"))
    val suffix = pattern.substring(pattern.indexOf("*") + 1, pattern.length)


    if(target.length < pattern.length - 1){
        return false
    }
    if(target.startsWith(prefix) && target.endsWith(suffix)){
        return true
    }


    return false
}