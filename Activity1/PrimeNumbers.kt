package com.ltts.genkproject1

fun main(){
    print("Enter value of n:")
    var number=Integer.valueOf(readLine())
    for(i in 1..number){
        var c = 0
        for(j in 1..i)
        {
            if(i%j==0)
            {
                c++
            }
        }
        if(c==2)
        {
            print(i)
            print(" ")
        }
    }
}
