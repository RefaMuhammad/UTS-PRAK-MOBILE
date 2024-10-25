package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Menghubungkan komponen tampilan
        val usernameEditText = findViewById<EditText>(R.id.etUsername)
        val passwordEditText = findViewById<EditText>(R.id.etPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)
        val registerTextView = findViewById<TextView>(R.id.tvRegister)

        // Data user dummy
        val dummyUsername = "admin"
        val dummyPassword = "admin123"

        // Set onClickListener untuk tombol login
        loginButton.setOnClickListener {
            val inputUsername = usernameEditText.text.toString()
            val inputPassword = passwordEditText.text.toString()

            // Cek apakah username dan password sesuai dengan data dummy
            if (inputUsername == dummyUsername && inputPassword == dummyPassword) {
                // Jika login berhasil
                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()
                // Pindah ke Activity lain jika diperlukan
                val intent = Intent(this, ListFoodActivity::class.java)
                startActivity(intent)
            } else {
                // Jika login gagal
                Toast.makeText(this, "Username atau password salah!", Toast.LENGTH_SHORT).show()
            }
        }

        // Set onClickListener untuk TextView Register jika diperlukan
        registerTextView.setOnClickListener {
            Toast.makeText(this, "Register clicked", Toast.LENGTH_SHORT).show()
            // Arahkan ke halaman registrasi jika ada
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}