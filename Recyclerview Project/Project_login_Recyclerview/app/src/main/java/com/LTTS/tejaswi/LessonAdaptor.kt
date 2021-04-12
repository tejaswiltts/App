package com.felbsn.odev2

import android.content.Context

class LessonAdaptor(moviesList: List<Lesson>, context: Context) : Adapter<LessonAdaptor.MyViewHolder?>() {
    private val lessonList: List<Lesson>
    var ctx: Context

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var hbutton: Button
        var hdelbutton: Button
        var lesson: Lesson? = null

        init {
            hbutton = view.findViewById(R.id.lessonName)
            hdelbutton = view.findViewById(R.id.delLesson)
        }
    }

    @Override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_lesson, parent, false)
        return MyViewHolder(itemView)
    }

    @Override
    fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val l: Lesson = lessonList[position]
        holder.hbutton.setText(l.name)
        holder.lesson = l
        holder.hbutton.setOnClickListener(object : OnClickListener() {
            @Override
            fun onClick(v: View?) {
                val intent = Intent(ctx, Description::class.java)
                intent.putExtra("name", holder.lesson.name)
                intent.putExtra("desc", holder.lesson.info)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                ctx.startActivity(intent)
            }
        })
        holder.hdelbutton.setOnClickListener(object : OnClickListener() {
            @Override
            fun onClick(v: View?) {
                lessonList.remove(holder.lesson)
                notifyDataSetChanged()
            }
        })
    }

    @get:Override
    val itemCount: Int
        get() = lessonList.size()

    init {
        lessonList = moviesList
        ctx = context
    }
}