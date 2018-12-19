package at.raithand17.collectionsandrecyclerview

import adapter.StudentAdapter
import android.database.sqlite.SQLiteConstraintException
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import beans.Student
import dbaccess.StudentsRoomDatabase
import kotlinx.android.synthetic.main.activity_student_database.*

class StudentDatabase : AppCompatActivity() {

    private var students = mutableListOf<Student>()
    val myAdapter = StudentAdapter()

    lateinit var db: StudentsRoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_database)

        db = StudentsRoomDatabase.getDatabase(this)

        Log.i("MyActivity", "onCreate")

        //students.add(Student("Test",1))
        students = db.studentDao.getAll().toMutableList()
        myAdapter.studentList = students
        recView.adapter = myAdapter
        recView.layoutManager = LinearLayoutManager(this)

    }

    fun addStudent(view: View) {
        val name = student_name.text.toString()
        val currentSemester = current_semester.text.toString().toIntOrNull() ?: 0

        val student = Student(name, currentSemester)


        try {
            db.studentDao.insert(student)
            students.add(student)
            myAdapter.updateList()
        }
        catch (e :SQLiteConstraintException)
        {
            Toast.makeText(this, "This name is already in the database", Toast.LENGTH_SHORT).show()
        }
    }
}