package mauro.correia.minutesaliveapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectDateBtn.setOnClickListener {view ->
            clickDatePicker(view)

        }
    }

    private fun clickDatePicker(view: View){

        val myCalendar = Calendar.getInstance();
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{view, selectedYear, selectedMonth, selectedDayOfMonth ->
                val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
                selectedDateView.setText(selectedDate)

                val dateFormater = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val today = dateFormater.parse("25/07/2022").time;
                val birthday = dateFormater.parse(selectedDate).time;

                val ageInMinutes = (today - birthday) / 60000;
                ageInMinutesView.text = "$ageInMinutes"

            }, year, month, day).show()
    }
}