package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.game.Dice

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
//            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
//            toast.show()
            //alert message
//            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            rollDice(R.id.textView,R.id.imageView)
            rollDice(R.id.textView2,R.id.imageView2)
        }

        val goToButton: Button = findViewById(R.id.buttonToCal)
        goToButton.setOnClickListener {
            val intent:Intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }
    }

    private fun rollDice(idTextView:Int,idImgView:Int) {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(idTextView)
        resultTextView.text = diceRoll.toString()
        // Find the ImageView in the layout
        val resultImgView: ImageView = findViewById(idImgView)
        // Determine which drawable resource ID to use based on the dice roll
        when (diceRoll) {
            1 -> resultImgView.setImageResource(R.drawable.dice_1)
            2 -> resultImgView.setImageResource(R.drawable.dice_2)
            3 -> resultImgView.setImageResource(R.drawable.dice_3)
            4 -> resultImgView.setImageResource(R.drawable.dice_4)
            5 -> resultImgView.setImageResource(R.drawable.dice_5)
            6 -> resultImgView.setImageResource(R.drawable.dice_6)
        }
//        val drawableResource = when (diceRoll) {
//            1 -> R.drawable.dice_1
//            2 -> R.drawable.dice_2
//            3 -> R.drawable.dice_3
//            4 -> R.drawable.dice_4
//            5 -> R.drawable.dice_5
//            else -> R.drawable.dice_6
//        }
        // Update the ImageView with the correct drawable resource ID
//        diceImage.setImageResource(drawableResource)

        // Update the content description
        resultImgView.contentDescription = diceRoll.toString()
    }

    private fun goToCalculator () {

    }
}