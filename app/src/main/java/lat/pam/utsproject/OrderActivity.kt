package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        // Menghubungkan komponen tampilan
        val namaMakananEditText = findViewById<EditText>(R.id.etFoodName)
        val jumlahPorsiEditText = findViewById<EditText>(R.id.etServings)
        val namaOrderEditText = findViewById<EditText>(R.id.etName)
        val noteEditText = findViewById<EditText>(R.id.etNotes)
        val orderButton = findViewById<Button>(R.id.btnOrder)

        orderButton.setOnClickListener {
            val namaMakanan = namaMakananEditText.text.toString()
            val jumlahPorsi = jumlahPorsiEditText.text.toString()
            val namaOrder = namaOrderEditText.text.toString()
            val note = noteEditText.text.toString()

            val intent = Intent(this, ConfirmationActivity::class.java).apply {
                putExtra("EXTRA_FOOD_NAME", namaMakanan)
                putExtra("EXTRA_PORTION", jumlahPorsi)
                putExtra("EXTRA_ORDER_NAME", namaOrder)
                putExtra("EXTRA_ADDITIONAL_NOTES", note)
            }
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun putExtras(s: String, namaMakanan: String) {

    }
}