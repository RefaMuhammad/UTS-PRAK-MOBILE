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
        val namaMakananTextView = findViewById<TextView>(R.id.etFoodName)
        val jumlahPorsiEditText = findViewById<EditText>(R.id.etServings)
        val namaOrderEditText = findViewById<EditText>(R.id.etName)
        val noteEditText = findViewById<EditText>(R.id.etNotes)
        val orderButton = findViewById<Button>(R.id.btnOrder)

        orderButton.setOnClickListener {
            val namaMakanan = namaMakananTextView.text.toString()
            val jumlahPorsi = jumlahPorsiEditText.text.toString()
            val namaOrder = namaOrderEditText.text.toString()
            val note = noteEditText.text.toString()

            val intent = Intent(this, ConfirmationActivity::class.java).apply {
                putExtras("EXTRA_Nama_Makanan", namaMakanan)
                putExtras("EXTRA_Jumlah_Porsi", jumlahPorsi)
                putExtras("EXTRA_Nama_Order", namaOrder)
                putExtras("EXTRA_Note", note)
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