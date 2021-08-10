package com.example.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.tetris.storage.AppPreference
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    var tvHighScore: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val btnNewGame: Button = findViewById(R.id.btn_new_game)
        val btnResetScore: Button = findViewById(R.id.btn_reset_score)
        val btnExit: Button = findViewById(R.id.btn_exit)
        tvHighScore = findViewById(R.id.tv_high_score)

        btnNewGame.setOnClickListener(this::startGame)
        btnResetScore.setOnClickListener(this::resetScore)
        btnExit.setOnClickListener(this::exitGame)
    }

    private fun startGame(view: View)
    {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    private fun resetScore(view: View)
    {
        val preference = AppPreference(this)
        preference.clearHighScore()
        Snackbar.make(view, "Score successfully reset", Snackbar.LENGTH_SHORT).show()
        tvHighScore?.text = "High score: ${preference.getHighScore()}"
    }

    private fun exitGame(view: View)
    {
        System.exit(0)
    }
}