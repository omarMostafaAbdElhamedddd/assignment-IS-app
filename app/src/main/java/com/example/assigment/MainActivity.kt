import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.CalculatorContract
import com.example.myapp.CalculatorModel
import com.example.myapp.R

class CalculatorActivity : AppCompatActivity(), CalculatorContract.View {

    private lateinit var presenter: CalculatorPresenter
    private val model: CalculatorContract.Model = CalculatorModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = CalculatorPresenter(this, model)

        val courseNameEditText = findViewById<EditText>(R.id.courseNameEditText)
        val creditHoursEditText = findViewById<EditText>(R.id.creditHoursEditText)
        val gradeEditText = findViewById<EditText>(R.id.gradeEditText)
        val addCourseButton = findViewById<Button>(R.id.addCourseButton)
        val calculateGpaButton = findViewById<Button>(R.id.calculateGpaButton)

        addCourseButton.setOnClickListener {
            val name = courseNameEditText.text.toString()
            val creditHours = creditHoursEditText.text.toString().toIntOrNull() ?: 0
            val grade = gradeEditText.text.toString().toDoubleOrNull() ?: 0.0
            presenter.addCourse(name, creditHours, grade)
            // Clear the input fields
            courseNameEditText.text.clear()
            creditHoursEditText.text.clear()
            gradeEditText.text.clear()
        }

        calculateGpaButton.setOnClickListener {
            presenter.calculateGpa()
        }
    }

    override fun showGpa(gpa: Double) {
        val gpaTextView = findViewById<TextView>(R.id.gpaTextView)
        gpaTextView.text = "GPA: %.2f".format(gpa)
    }
}