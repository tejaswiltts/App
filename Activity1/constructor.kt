package com.ltts.genkproject1

import java.util.*

open class Parent {
    constructor(name: String, id: Int) {
        println("Name=${name}")
        println("id=${id}")
    }

    constructor(name: String, id: Int, pass: String) {
        println("Name = ${name}")
        println("Id = ${id}")
        println("Password = ${pass}")

    }
}

    class Child : Parent {
        constructor(name: String, id: Int) : super(name, id) {
            println("Name=${name}")
            println("id=${id}")
        }

        constructor(name: String, id: Int, pass: String) : super(name, id, "password") {
            println("Name = ${name}")
            println("Id = ${id}")
            println("Password = ${pass}")
        }
    }
        fun main(args:Array<String>) {
            var sc= Scanner(System.`in`)
            var name=sc.nextLine()
            var id=sc.nextInt()
            var pass=sc.nextLine()
            println("$name")
            println("$id")
            println("$pass")
        }

