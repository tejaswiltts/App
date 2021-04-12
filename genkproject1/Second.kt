package com.ltts.genkproject1

import java.util.*

fun main(){
    var sc= Scanner(System.`in`)
    var a=sc.nextInt()
    var b=sc.nextInt()
   println("enter option:")

    var num= readLine()
    var numberProvided = when(num) {
        "1" -> println("$a+$b=${a+b}")
      "2"-> println("$a-$b=${a-b}")
       "3"-> println("$a*$b=${a*b}")
       "4" ->  println("$a/$b=${a/b}")
       "5" ->  println("$a%$b=${a%b}")
        else -> "invalid number"
    }
    println("$numberProvided")

}