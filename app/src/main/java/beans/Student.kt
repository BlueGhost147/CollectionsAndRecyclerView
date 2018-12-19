package beans

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Student(@PrimaryKey val name: String, val currentSemester: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Student

        if (name != other.name) return false
        if (currentSemester != other.currentSemester) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + currentSemester
        return result
    }

    override fun toString(): String {
        return "$name currentSemester=$currentSemester"
    }


}