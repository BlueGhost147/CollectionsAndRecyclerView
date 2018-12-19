package at.raithand17.collectionsandrecyclerview

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import beans.Student
import kotlinx.android.synthetic.main.activity_user_data.*
import java.lang.ClassCastException

class UserDataActivity : AppCompatActivity() {

    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)
        sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
    }

    fun saveStudent(v : View)
    {
        try {
            val sName = editStudentName.text.toString()
            val sSemester = editStudentSemserter.text.toString().toInt()
            Student(sName,sSemester)
            sharedPreferences.edit().putString("StudentName", sName).apply()
            sharedPreferences.edit().putInt("StudentSemester", sSemester).apply()
        }
        catch (e : ClassCastException)
        {}
    }

    fun readStudent(v : View)
    {
        editStudentName.setText(sharedPreferences.getString("StudentName",""))
        editStudentSemserter.setText(sharedPreferences.getInt("StudentSemester",0).toString())
    }
}
