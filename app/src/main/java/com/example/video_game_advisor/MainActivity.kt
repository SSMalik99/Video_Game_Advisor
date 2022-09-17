package com.example.video_game_advisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findGames = findViewById<Button>(R.id.game_button_1)
        findGames.setOnClickListener {
//            get selected genre
            val genre = findViewById<Spinner>(R.id.game_spin_1).selectedItem
//            set title of the selected genre
            val gameText = findViewById<TextView>(R.id.binding_1)
            gameText.text = genre.toString()

//            Add description to the selected point
            val descriptionView = findViewById<TextView>(R.id.description_view)
            descriptionView.text = getGamesDescription(genre.toString())
            descriptionView.visibility = View.VISIBLE

//set label for available games
            findViewById<TextView>(R.id.available_games_lable).visibility = View.VISIBLE

//            set game into the game view
            val games = findViewById<TextView>(R.id.gamesList)
            games.text = getGames(genre.toString()).reduce{str, item->str + '\n' + item}
            games.visibility = View.VISIBLE
        }
    }

    private fun getGames(genre: String) : List<String> {
        return when(genre) {
            "Action" -> listOf("GTA5", "Cool Shot", "Hack 2 Speed")
            "Adventure" -> listOf("Mosture Blue", "Water Mining", "RET Ring")
            "Sports" -> listOf("play33 ", "Cricket40", "F360")
            "Crime" -> listOf("Walker's Detah", "65er Martin")
            else -> listOf("Mario", "Xinzo")
        }
    }

    private fun getGamesDescription(genre: String) : String {
        return when(genre) {
            "Action" -> getString(R.string.Action_description)
            "Adventure" -> getString(R.string.Adventure_description)
            "Sports" -> getString(R.string.Sports_description)
            "Crime" -> getString(R.string.Crime_description)
            else -> "You havn't selected a valid game genre. Modify your search"
        }
    }
}