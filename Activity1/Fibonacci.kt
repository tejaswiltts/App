package com.ltts.genkproject1
fun main()
{
    var r = Integer.valueOf(readLine())
    var a= 0
    var b = 1
    print(a)
    print(" ")
    print(b)
    print(" ")
    for(i in 1..r-2)
    {   var c = a+b
        print(c)
        print(" ")
        a=b
        b=c
    }
}

