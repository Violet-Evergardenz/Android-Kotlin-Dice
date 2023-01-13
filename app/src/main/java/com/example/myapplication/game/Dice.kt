package com.example.myapplication.game

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}