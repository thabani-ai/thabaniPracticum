package vcmsa.ci.musicplaylistapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // Companion object to store parallel arrays
    companion object {
        val songs = mutableListOf<String>()
        val artistName = mutableListOf<String>()
        val rate = mutableListOf<Int>()
        val comments = mutableListOf<String>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val songInput = findViewById<EditText>(R.id.etSongName)
        val artistInput = findViewById<EditText>(R.id.etArtist)
        val ratingInput = findViewById<EditText>(R.id.etRating)
        val commentsInput = findViewById<EditText>(R.id.etComments)

        val addButton = findViewById<Button>(R.id.btnAdd)
        val goToSecond = findViewById<Button>(R.id.btnSecondScreen)
        val exitButton = findViewById<Button>(R.id.btnExit)

        addButton.setOnClickListener {
            val song = songInput.text.toString().trim()
            val artist = artistInput.text.toString().trim()
            val ratings = ratingInput.text.toString().trim()
            val comment = commentsInput.text.toString().trim()

            if (song.isEmpty() || artist.isEmpty() || ratings.isEmpty()) {
                Toast.makeText(this, "Please fill in all required fields.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val rating = ratings.toIntOrNull()
            if (rating == null || rating <= 0) {
                Toast.makeText(this, "Enter a valid rating (> 0).", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            songs.add(song)
            artistName.add(artist)
            rate.add(rating)
            comments.add(comment)

            Toast.makeText(this, "Song added!", Toast.LENGTH_SHORT).show()

            // Clear inputs
            songInput.text.clear()
            artistInput.text.clear()
            ratingInput.text.clear()
            commentsInput.text.clear()
        }

        goToSecond.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
        exitButton.setOnClickListener {
            finish()
        }
    }
}