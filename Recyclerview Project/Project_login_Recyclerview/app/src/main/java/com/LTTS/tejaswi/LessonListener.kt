package com.felbsn.odev2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import java.util.ArrayList
import java.util.List

class LessonListener : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var adaptor: LessonAdaptor? = null
    private val lessons: List<Lesson> = ArrayList()
    @Override
    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_listener)
        setTitle("Lesson Listener")
        recyclerView = findViewById(R.id.recyclerView) as RecyclerView?
        adaptor = LessonAdaptor(lessons, getApplicationContext())
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(getApplicationContext())
        recyclerView.setLayoutManager(mLayoutManager)
        recyclerView.setItemAnimator(DefaultItemAnimator())
        recyclerView.setAdapter(adaptor)
        initLessons()
    }

    fun initLessons() {
        for (i in 0..29) {
            val l = Lesson()
            l.name = "Item $i"
            l.info = " Item $i added..."
            lessons.add(l)
        }
        adaptor.notifyDataSetChanged()
    }
}