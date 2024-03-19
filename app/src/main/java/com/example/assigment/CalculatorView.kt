package com.example.myapp


interface CalculatorContract {
    interface View {
        fun showGpa(gpa: Double)
    }

    interface Presenter {
        fun addCourse(name: String, creditHours: Int, grade: Double)
        fun calculateGpa()
    }

    interface Model {
        fun addCourse(course: Course)
        fun calculateGpa(): Double
    }
}
