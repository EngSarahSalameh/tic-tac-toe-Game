package com.engsarahsalameh.tictactoy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnSelected (view: View){ //view is instance from class View
     // To convert view to button
        val btnChoise = view as Button
        var cellID = 0
        when(btnChoise.id){
            R.id.btn1 -> cellID = 1
            R.id.btn2 -> cellID = 2
            R.id.btn3 -> cellID = 3
            R.id.btn4 -> cellID = 4
            R.id.btn5 -> cellID = 5
            R.id.btn6 -> cellID = 6
            R.id.btn7 -> cellID = 7
            R.id.btn8 -> cellID = 8
            R.id.btn9 -> cellID = 9
        }
        playGame (cellID,btnChoise)
    }
    //To store each player selected cells
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    fun playGame (cellID:Int,btnChoise:Button){
        if(activePlayer==1) {
        //TO make the button with X label
            btnChoise.text = "X"
        //To change button color when user click on it
            btnChoise.setBackgroundResource(R.color.green)
        //To add selected cell to player cells
            player1.add(cellID)
            activePlayer = 2
            autoPaly()}
        else {
            btnChoise.text = "O"
            btnChoise.setBackgroundResource(R.color.blue)
            player2.add(cellID)
            activePlayer = 1
        }
        btnChoise.isEnabled=false //To prevent playes from click the same cell twice
        checkWinner()
    }

    fun checkWinner (){
        var winner = -1
        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner =1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner =2
        }
        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner =1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner =2
        }
        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner =1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner =2
        }
        //col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner =1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner =2
        }
        //col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner =1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner =2
        }
        //col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner =1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner =2
        }
        if(winner != -1) {
            if(winner == 1) {
                Toast.makeText(this,"Player 1 is the winner", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,"Player 2 is the winner", Toast.LENGTH_LONG).show()
            }
        }
    }
    //To play with the device
    fun autoPaly () {
        //To find witch cells are empty
        val emptyCells = ArrayList<Int>()
        for(cellID in 1..9){
            if(!(player1.contains(cellID) || player2.contains(cellID))) { //mean no one chose this cell
                emptyCells.add(cellID)
            }
        }
        val r = Random
        val randomIndex = r.nextInt(emptyCells.size - 0 ) // To chose random number from 1 to 9
        val cellIDEmpty = emptyCells[randomIndex]
        var btnSelect:Button ?= null
        when(cellIDEmpty){
            1 -> btnSelect!!.id = R.id.btn1
            2 -> btnSelect!!.id = R.id.btn2
            3 -> btnSelect!!.id = R.id.btn3
            4 -> btnSelect!!.id = R.id.btn4
            5 -> btnSelect!!.id = R.id.btn5
            6 -> btnSelect!!.id = R.id.btn6
            7 -> btnSelect!!.id = R.id.btn7
            8 -> btnSelect!!.id = R.id.btn8
            9 -> btnSelect!!.id = R.id.btn9
        }
       playGame(cellIDEmpty , btnSelect!!)
    }


}