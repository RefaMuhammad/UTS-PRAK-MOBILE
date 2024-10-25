package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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

        val foodName = intent.getStringExtra("EXTRA_Nama_Makanan")
        val portion = intent.getStringExtra("EXTRA_Jumlah_Porsi")
        val orderName = intent.getStringExtra("EXTRA_Nama_Order")
        val additionalNotes = intent.getStringExtra("EXTRA_NOTE")

        // Tampilkan data di tampilan konfirmasi
        foodNameTextView.text = foodName
        portionTextView.text = portion
        orderNameTextView.text = orderName
        additionalNotesTextView.text = additionalNotes


        menuButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}