package at.raithand17.collectionsandrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import beans.Student

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create a list of 5 Students
        val studentList = listOf<Student>(
            Student("Bob",1),
            Student("Sam",2),
            Student("Ben",3),
            Student("Jan",4),
            Student("May",5))

        // Log out the name of the Student at Index 2
        Log.i("StudentInfo",studentList[2].name)

        // Can we add an additional Student to the List?
        // -- No because the list is immutable!

        // Create a mutable list of 5 Students
        val studentListMutable = mutableListOf<Student>(
            Student("Bob",1),
            Student("Sam",2),
            Student("Ben",3),
            Student("Jan",4),
            Student("May",5))

        // Assign a different Student Object to Index 3
        studentListMutable[3] = Student("Jerry",5)

        // Log out the name of the Student at Index 3
        Log.i("StudentInfo from list",studentList[3].name)

        // Add an Additional Student to the List
        studentListMutable.add(Student("Rick",9))

        //Log all Student Names in the List
        for (s in studentListMutable)
        {
            Log.i("StudentInfo from m",s.name)
        }

        // Create a Set of 5 Students (two of them should have the same Name and CurrentSemester)
        val studentSet = setOf<Student>(
            Student("Bob",1),
            Student("Bob",1),
            Student("Bob",1),
            Student("Bob",1),
            Student("Bob",1))

        // Log all Student Names in the Set
        for (s in studentSet)
        {
            Log.i("StudentInfo from set",s.name)
        }

        // Shouldn't a Set hold only unique elements? What is Missing?
        // equals and hash method in student is not implemented
    }
}
