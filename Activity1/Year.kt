package com.ltts.genkproject1

fun main()
{
    var year = Integer.valueOf(readLine())


    if (year % 4 == 0) {


        if (year % 100 == 0) {


            if (year % 400 == 0)
                println("its a Leap Year")
            else
                println("Its Not a Leap Year")
        }


        else
            println("Its a Leap Year")
    }

    else
        println("Its Not a Leap Year")


}