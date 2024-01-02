package sliver

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val numbers = br.readLine().split(" ").map{ it.toInt() }.toMutableList()

    var current = 1
    var stack = mutableListOf<Int>()

    while (numbers.isNotEmpty()){
        val top = numbers.first()
        if(top == current) {
            numbers.removeAt(0)
            current++
        }else if (stack.isNotEmpty() && stack.last() == current) {
            stack.removeAt(stack.lastIndex)
            current++
        }else{
            stack.add(top)
            numbers.removeAt(0)
        }
    }
    
    while (stack.isNotEmpty()){
        if(stack.last() == current){
            stack.removeAt(stack.lastIndex)
            current++
        }else{
            break
        }
    }
    if(stack.isEmpty()) {
        println("Nice")
    }else{
        println("Sad")
    }
}