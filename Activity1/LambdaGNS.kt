package com.ltts.genkproject1

fun main()
{
    var array = arrayOf(6,3,8,5)
    var lambda = {->
        var rev = array.sorted()
        println(" Smallest Element: ${rev[0]}")
        println("Largest Element: ${rev[array.size-1]}")
    }
    lambda()
}
