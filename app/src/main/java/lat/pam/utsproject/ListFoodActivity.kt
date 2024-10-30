package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList: List<Food>
    private lateinit var adapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_food)
        // Menghubungkan komponen tampilan
        val orderButton = findViewById<Button>(R.id.btnOrder2)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        // Menyiapkan data makanan dengan informasi lengkap
        foodList = listOf(
            Food(
                name = "Batagor",
                description = "Batagor asli enak dari Bandung",
                image = R.drawable.batagor,
                price = "$",
                category = "Makanan",
                deliveryTime = "30-40 min",
                deliveryCost = "Ongkir 1rb",
                discount = "10% off",
                discountInfo = "Diskon 10%, maks. 5rb"
            ),
            Food(
                name = "Black Salad",
                description = "Salad segar yang dibuat secara langsung",
                image = R.drawable.black_salad,
                price = "$$",
                category = "Salad",
                deliveryTime = "25-35 min",
                deliveryCost = "Ongkir 1rb",
                discount = "30% off",
                discountInfo = "Diskon 30%, maks. 10rb"
            ),
            Food(
                name = "Cappucino",
                description = "Kopi cappucino asli yang dibuat dari Kopi Arabica",
                image = R.drawable.cappuchino,
                price = "$",
                category = "Minuman",
                deliveryTime = "20-30 min",
                deliveryCost = "Ongkir 1rb",
                discount = "10% off",
                discountInfo = "Diskon 10%, maks. 5rb"
            ),
            Food(
                name = "Cheesecake",
                description = "Cheesecake dengan keju premium dari belanda",
                image = R.drawable.cheesecake,
                price = "$$$$",
                category = "Kue",
                deliveryTime = "25-35 min",
                deliveryCost = "Ongkir 5rb",
                discount = "40% off",
                discountInfo = "Diskon 40%, maks. 40rb"
            )
        )

        adapter = FoodAdapter(foodList)
        recyclerView.adapter = adapter

        orderButton.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }
    }
}