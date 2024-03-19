import com.example.myapp.CalculatorContract

//import com.example.calculatorapp.mvp.CalculatorModel
//import com.example.calculatorapp.mvp.CalculatorView


abstract class CalculatorPresenter(private val view: CalculatorContract.View, private val model: CalculatorContract.Model) :
    CalculatorContract.Presenter {

    override fun addCourse(name: String, creditHours: Int, grade: Double) {
        model.addCourse(Course(name, creditHours, grade))
    }

    override fun calculateGpa() {
        val gpa = model.calculateGpa()
        view.showGpa(gpa)
    }
}
