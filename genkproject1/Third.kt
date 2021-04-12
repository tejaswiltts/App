package com.ltts.genkproject1
class MyClass(myname:String, age:Int) {
    init{
        var na=myname
        var myage=age
        println("my name is $na myage is $myage")
    }
    constructor(un:String,cage:Int,a:Int,b:Int): this(un,a) {

    }

    var name="tejaswi"
    fun myFun() {
        println("my name is $name");
    }

}
fun main(args: Array<String>) {


var mc=MyClass( "teja", 20,21,6)
    mc.myFun()
    mc.name



}