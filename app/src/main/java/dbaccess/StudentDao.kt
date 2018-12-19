package dbaccess

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import beans.Student

@Dao
interface StudentDao {
    @Insert
    fun insert(student: Student)

    @Query ("SELECT * FROM Student")
    fun getAll() : List<Student>

    @Query ("SELECT * FROM Student WHERE currentSemester = 3")
    fun getTSemster() : List<Student>
}