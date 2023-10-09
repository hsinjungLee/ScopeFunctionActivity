package edu.temple.scopefunctionactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // You can test your helper functions by  calling them from onCreate() and
        // printing their output to the Log, which is visible in the LogCat:
        Log.d("function output", getTestDataArray().toString())
        Log.d("function output", testData.toString())


        val numbers = listOf(1.0, 2.0, 3.0, 4.0, 5.0)
        if (averageLessThanMedian(numbers)) {
            Log.d("Comparison", "Average is less than the median.")
        } else {
            Log.d("Comparison", "Average is greater than or equal to the median.")
        }


    }


    /* Convert all the helper functions below to Single-Expression Functions using Scope Functions */
    // eg. private fun getTestDataArray() = ...

    // HINT when constructing elaborate scope functions:
    // Look at the final/return value and build the function "working backwards"

    // Return a list of random, sorted integers
    private fun getTestDataArray() : List<Int> {
        val testArray = MutableList(10){Random.nextInt()}.apply { sort() }
        testArray.sort()
        return testArray
    }
    val testData = getTestDataArray()



    // Return true if average value in list is greater than median value, false otherwise
    private fun averageLessThanMedian(listOfNumbers: List<Double>): Boolean {
        val avg = listOfNumbers.average()
        val sortedList = listOfNumbers.sorted()
        val median = if (sortedList.size % 2 == 0)
            (sortedList[sortedList.size / 2] + sortedList[(sortedList.size - 1) / 2]) / 2
        else
            sortedList[sortedList.size / 2]

        return avg < median

    }



    // Create a view from an item in a collection, but recycle if possible (similar to an AdapterView's adapter)
    private fun getView(position: Int, recycledView: View?, collection: List<Int>, context: Context): View {
        val textView: TextView

        if (recycledView != null) {
            textView = recycledView as TextView
        } else {
            textView = TextView(context)
            textView.setPadding(5, 10, 10, 0)
            textView.textSize = 22f

            val position = 0
            val recycledView: View? = null
            val collection = listOf(1, 2, 3, 4, 5)
            val context = this

            val view = getView(position, recycledView, collection, context)
        }

        textView.text = collection[position].toString()

        return textView

    }


}