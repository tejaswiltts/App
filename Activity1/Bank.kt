package com.ltts.genkproject1

import java.util.*
import kotlin.collections.ArrayList



data class AddAccount(val account_num:Int,val account_name:String,val account_type:String)
{


    override fun toString(): String{
        val Str = "{account_num = ${account_num}, account_name = ${account_name} , acc_Type = ${account_type}}"
        return Str

    }

}



class Display
{

}

open class BankMain
{
    var account_num = 1
    var array = ArrayList<AddAccount>()
    fun add_account()
    {
        println("Enter Account Holder Name: ")
        var name = readLine()!!
        println("Enter Type of Account: ")
        var account_type = readLine()!!
        println("Basic 500 amount added to the bank account!!")

        var obj = AddAccount(account_num,name,account_type)


        var array = ArrayList<AddAccount>()
        array.add(AddAccount(account_num,name,account_type))
        var arr = array.toString()
        println(arr)


    }
    fun display_accnum()
    {
        println("Enter Account Number: ")
        var account_num = Integer.valueOf(readLine())




    }
}

fun main()
{
    var sc = Scanner(System.`in`)
    println("Bank Application")
    println("1.Open New Account")
    println("2.Deposit Amount")
    println("3.Withdraw Amount")
    println("4.Search by Account no")
    println("5.Search by Name")
    println("6.CLose Account")
    println("7.Exit")
    while(true)
    {
        println("Enter Your Choice: ")
        var c = sc.nextInt()

        var numberProvided = when(c) {
            1 ->  BankMain().add_account()
            2 -> "Two"
            3 -> "Three"
            4 -> BankMain().display_accnum()

            5 -> "Five"
            else -> "invalid number"
        }
    }
}

