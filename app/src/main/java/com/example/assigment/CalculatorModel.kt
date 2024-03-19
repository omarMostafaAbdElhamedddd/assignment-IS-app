package com.example.myapp
class CalculatorModel : CalculatorContract.Model {

    private val courses = mutableListOf<Course>()

    override fun addCourse(course: Course) {
        courses.add(course)
    }

    override fun calculateGpa(): Double {
        val totalCreditHours = courses.sumOf { it.creditHours }
        val totalGradePoints = courses.sumOf { it.creditHours * it.grade }
        return if (totalCreditHours > 0) {
            totalGradePoints.toDouble() / totalCreditHours
        } else {
            0.0
        }
    }
}
