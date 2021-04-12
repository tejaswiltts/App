package com.ltts.genkproject1

import java.util.*

fun main(){

    val sc=Scanner(System.`in`)
    println("Enter the Radius of the circle:")
    val radius=sc.nextInt()
    val area=3.14*radius*radius
    val perimeter= 2*3.14*radius
    val length=perimeter/4
    println("area:$area")
    println("circumference: $perimeter")
    println("length of side square: $length ")

}