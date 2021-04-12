package com.ltts.genkproject1
class outerClass(name:String) {

     var name:String=""




    inner class innerClass() {
        var des: String = "hello!"
        private var age: Int = 20
        var ph: Int = 2345657
        fun myFun() {
            println("name:$name")
            println("age:$age")
            println("phone:$ph")
        }
    }
}
        fun main(args: Array<String>){
            println(outerClass(name="tejaswi").innerClass().des)
            var c = outerClass(name="tejaswi").innerClass()
            c.myFun()

        }










