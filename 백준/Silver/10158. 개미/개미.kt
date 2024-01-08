
import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (w, h) = br.readLine().split(" ").map{ it.toInt() }
    val (p, q) = br.readLine().split(" ").map{ it.toInt() }
    val t = br.readLine().toInt()

    var xMod = t % (2*w)
    var yMod = t % (2*h)

    var dx:Int = p
    var dy:Int = q

    var dir = true
    while (xMod >0){
        if(dir){
            if(dx + xMod <= w){
                dx +=xMod
                xMod = 0
            }else{
                xMod -= w-dx
                dx = w
                dir = false
            }
        }else{
            if(dx - xMod >= 0){
                dx -=xMod
                xMod = 0
            }else{
                xMod -= dx
                dx = 0
                dir = true
            }
        }
    }
    dir = true
    while (yMod >0){
        if(dir){
            if(dy + yMod <= h){
                dy +=yMod
                yMod = 0
            }else{
                yMod -= h-dy
                dy = h
                dir = false
            }
        }else{
            if(dy - yMod >= 0){
                dy -=yMod
                yMod = 0
            }else{
                yMod -= dy
                dy = 0
                dir = true
            }
        }
    }
    println("$dx $dy")

    br.close()
}