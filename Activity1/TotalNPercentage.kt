package com.ltts.genkproject1

import java.util.*

fun main(args: Array<String>) {
    val sc=Scanner(System.`in`)
    println("Enter the marks of 3 subjects:")
   val e=sc.nextDouble()
   val s=sc.nextDouble()
   val m=sc.nextDouble()
    val total= e+s+m
    println(" TOTAL: $total")
    println("PERCENTAGE: ${((e+s+m)/300)*100}")

}