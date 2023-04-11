package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
//import android.widget.TextView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
//        val buttonOneTextView: TextView = findViewById(R.id.textView)
        val buttonOneDiceImage: ImageView = findViewById(R.id.imageView)

        val rollButton2: Button = findViewById(R.id.button2)
//        val buttonTwoTextView: TextView = findViewById(R.id.textView2)
        val buttonTwoDiceImage: ImageView = findViewById(R.id.imageView2)

        val rollBothButton: Button = findViewById(R.id.button3)

        val myImageViews = listOf<ImageView>(buttonOneDiceImage, buttonTwoDiceImage)
        rollButton.setOnClickListener { rollDice(listOf(myImageViews.first())) }
        rollButton2.setOnClickListener { rollDice(listOf(myImageViews.last())) }
        rollBothButton.setOnClickListener { rollDice(myImageViews) }
        // Do a dice roll when the app starts
        rollDice(myImageViews)
    }

    private fun rollDice(imageViews: Collection<ImageView>) {
        val luckyNumber = 4
        var hit = false
        for (diceImage in imageViews) {
            // Create new Dice object with 6 sides and roll it
            val dice = Dice(6)
            val diceRoll = dice.roll()
            // Update the screen with the dice roll
            // Determine which drawable resource ID to use based on the dice roll
            val drawableResource = when (diceRoll) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            // Update the ImageView with the correct drawable resource ID
            diceImage.setImageResource(drawableResource)
            // Update the content description
            diceImage.contentDescription = diceRoll.toString()
            if(diceRoll == luckyNumber) hit = true
        }
        if (hit) {
            println("You win!")
        } else {
            println("You didn't win, try again!")
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