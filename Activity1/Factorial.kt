package com.ltts.genkproject1

fun main()
{
    var a = Integer.valueOf(readLine())
    var b = {x:Int ->
        var s = 1
        for(i in 1..x)
        {
            s = s*i
        }
        println("Factorial of  ${x}: ${s}")
    }
    b(a)
}
