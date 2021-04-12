package com.ltts.genkproject1

fun main(args:Array<String>) {
    val quantity=Integer.valueOf(readLine())
    val unit=Integer.valueOf(readLine())
    val total=quantity*unit
    val discount=(total*15/100)
    val bill=total-discount
    println("Bill:$bill")
}