package vcmsa.ci.musicplaylistapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    private lateinit var outputText: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        outputText = findViewById(R.id.tvOutput)
        val showAllBtn = findViewById<Button>(R.id.btnShowAll)
        val averageBtn = findViewById<Button>(R.id.btnAverageRating)
        val backBtn = findViewById<Button>(R.id.btnBack)

        showAllBtn.setOnClickListener {
            displayItems(showAll = true)
        }

        averageBtn.setOnClickListener {
            if (MainActivity.rate.isEmpty()) {
                outputText.text = "No ratings available to calculate average."
            } else {
                val total = MainActivity.rate.sum()
                val average = total.toDouble() / MainActivity.rate.size
                outputText.text = "Average Rating: %.2f".format(average)
            }
        }

        backBtn.setOnClickListener {
            finish()
        }
    }

    private fun displayItems(showAll: Boolean) {
        val builder = StringBuilder()

        for (i in MainActivity.songs.indices) {
            val rating = MainActivity.rate[i]
            if (showAll || rating >= 2) {
                builder.append("Song: ${MainActivity.songs[i]}\n")
                builder.append("Artist: ${MainActivity.artistName[i]}\n")
                builder.append("Rating: $rating\n")
                builder.append("Comments: ${MainActivity.comments[i]}\n\n")
            }
        }

        outputText.text = if (builder.isEmpty()) "No songs to show." else builder.toString()
    }
}
