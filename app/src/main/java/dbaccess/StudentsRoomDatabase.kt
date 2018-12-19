package dbaccess

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import beans.Student

@Database(entities = [Student::class], version = 1)
abstract class StudentsRoomDatabase : RoomDatabase() {

    abstract val studentDao: StudentDao

    companion object {
        fun getDatabase(context: Context): StudentsRoomDatabase {
            return Room.databaseBuilder(context, StudentsRoomDatabase::class.java, "student-db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}