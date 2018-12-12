package at.raithand17.collectionsandrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import beans.Student

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Part 1

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

        // Part 2

        // Create a mutable Set of 5 Students (at least one with the name "Rob")
        val studentSetMutable = mutableSetOf<Student>(
            Student("Rob",1),
            Student("Sam",2),
            Student("Ben",3),
            Student("Jan",4),
            Student("May",5))

        // Add another Student with the same Name and current Semester as a Student already in the Set
        studentSetMutable.add(Student("Ben",3))

        //Add another Student with different Values
        studentSetMutable.add(Student("Jen",11))

        // Log all Student Names and currentSemesters in the Set
        for (s in studentSetMutable)
        {
            Log.i("StudentInfo from m. set",s.toString())
        }

        // Log all Student Names and currentSemesters in the Set that have the Name "Rob"
        for (s in studentSetMutable)
        {
            if(s.name == "Rob")
                Log.i("StudentInfo Rob",s.toString())
        }

        // Create a Map with two entries:

        val ima18List = listOf(
            Student("Tyrion", 1),
            Student("Jon", 1)
        )
        val ima17List = mutableListOf(
            Student("Sansa", 3),
            Student("Arya", 3),
            Student("Bran", 3)
        )
        val studentMap = mapOf<String, List<Student>>(
            "IMA18" to ima18List,
            "IMA17" to ima17List
        )

        // Iterate through the map and Log each Students Studies, Name and current Semester
        // Hint: for ((key, value) in map)
        logMap("studentMap",studentMap)

        // Add a new entry to the ima17List and log the values above again. What happened here? Isn't the Map immutable?
        ima17List.add(Student("David",7))
        logMap("studentMapN",studentMap)

        // Create a mutable Map based on the Map above (Hint: toMutableMap)
        val studentMapMutable = studentMap.toMutableMap()

        // Add a new List ima16List with 2 Students
        val ima16List = mutableListOf(
            Student("Sansa Jr", 3),
            Student("Arya Jr", 3)
        )

        // Add the List to the mutable Map
        studentMapMutable.put("IMA16",ima16List)

        // Log the values same as for the Map.
        logMap("studentMapM",studentMapMutable)

    }

    fun logMap(logInfo : String, map : Map<String,List<Student>>)
    {
        for ((studies, students) in map)
        {
            for (student in students)
                Log.i("StudentInfo $logInfo",studies + " " + student.toString())
        }
    }
}