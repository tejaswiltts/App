package com.ltts.genkproject1

import java.util.Scanner;

class PointOfSale
{

    constructor(name:String,mobile_num:Int,address:String,items:Int)
    {


        println("The Customer Name is : ${name}")
        println("The Customer Mobile Number is : ${mobile_num}")
        println("The Customer Address is : ${address}")



    }
}





fun main()
{
    var sc = Scanner(System.`in`)
    println("Customer Name: ")
    val name = sc.nextLine()
    println("Customer Mobile Num: ")
    var mobile_num:Int = sc.nextInt()
    println("Customer Address: ")
    val address = sc.next()
    println(" Number Of Items: ")
    var items = sc.nextInt()
    println(" Poduct Details:  ")
    var array = ArrayList<Any>()
    var bill = 0
    for(i in 1..items)
    {
        println("Enter Product Id: ")
        var product_id = Integer.valueOf(readLine())
        array.add(product_id)
        println("Enter Product Name: ")
        val product_name = readLine()!!
        array.add(product_name)
        println("Enter Product Price: ")
        var product_price = Integer.valueOf(readLine())
        array.add(product_price)
        println("Enter Product Quantity: ")
        var product_quant = Integer.valueOf(readLine())
        array.add(product_quant)
        bill = bill+(product_quant*product_price)
    }
    var obj = PointOfSale(name,mobile_num,address,items)
    println()
    println("Product Details")
    var j=0
    for(i in 1..items)
    {
        println("Product Id is : ${array.get(j)}")
        j++
        println("product Name is : ${array.get(j)}")
        j++
        println("Product Price is : ${array.get(j)}")
        j++
        println("Product Quant is : ${array.get(j)}")
        j++

    }
    println()

    println("The Total bill is ${bill}")
    println("--------------------")
    println("Thank you For Shopping! \n have a great day!!")
}
