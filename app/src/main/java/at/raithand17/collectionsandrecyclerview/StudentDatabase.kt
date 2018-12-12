package at.raithand17.collectionsandrecyclerview

import adapter.StudentAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import beans.Student
import kotlinx.android.synthetic.main.activity_student_database.*

class StudentDatabase : AppCompatActivity() {

    private val students = mutableListOf<Student>()
    val myAdapter = StudentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_database)
        Log.i("MyActivity", "onCreate")

        students.add(Student("Test",1))
        myAdapter.studentList = students
        recView.adapter = myAdapter
        recView.layoutManager = LinearLayoutManager(this)

    }

    fun addStudent(view: View) {
        val name = student_name.text.toString()
        val currentSemester = current_semester.text.toString().toIntOrNull() ?: 0

        val student = Student(name, currentSemester)
        students.add(student)
        myAdapter.updateList(students)
    }
}