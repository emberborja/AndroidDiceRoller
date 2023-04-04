package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        val buttonOneTextView: TextView = findViewById(R.id.textView)


        val rollButton2: Button = findViewById(R.id.button2)
        val buttonTwoTextView: TextView = findViewById(R.id.textView2)

        val rollBothButton: Button = findViewById(R.id.button3)

        val myTextViews = listOf<TextView>(buttonOneTextView, buttonTwoTextView)
        rollButton.setOnClickListener { rollDice(listOf(myTextViews.first())) }
        rollButton2.setOnClickListener { rollDice(listOf(myTextViews.last())) }
        rollBothButton.setOnClickListener { rollDice(myTextViews) }
    }

    private fun rollDice(textViews: Collection<TextView>) {
        for (textView in textViews) {
            // Create new Dice object with 6 sides and roll it
            val dice = Dice(6)
            val diceRoll = dice.roll()
            // Update the screen with the dice roll
            textView.text = diceRoll.toString()
        }
    }
}

/**
 * Roll the dice and update the screen with the result.
 */
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}