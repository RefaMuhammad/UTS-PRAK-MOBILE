package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)

        val foodNameTextView = findViewById<TextView>(R.id.tvFoodName)
        val portionTextView = findViewById<TextView>(R.id.tvPortion)
        val orderNameTextView = findViewById<TextView>(R.id.tvOrderName)
        val additionalNotesTextView = findViewById<TextView>(R.id.tvAdditionalNotes)

        val menuButton =  findViewById<Button>(R.id.backtoMenu)

        val foodName = intent.getStringExtra("EXTRA_FOOD_NAME")
        val portion = intent.getStringExtra("EXTRA_PORTION")
        val orderName = intent.getStringExtra("EXTRA_ORDER_NAME")
        val additionalNotes = intent.getStringExtra("EXTRA_ADDITIONAL_NOTES")

        // Tampilkan data di tampilan konfirmasi
        foodNameTextView.text = "Food Name: $foodName"
        portionTextView.text = "Number of Servings: $portion pax"
        orderNameTextView.text = "Ordering Name: $orderName"
        additionalNotesTextView.text = "Additional Notes: $additionalNotes"


        menuButton.setOnClickListener{
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}