package lat.pam.utsproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class FoodAdapter(private val foodList: List<Food>) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageFood: ImageView = itemView.findViewById(R.id.imageFood)
        private val tvFoodName: TextView = itemView.findViewById(R.id.tvFoodName)
        private val tvRating: TextView = itemView.findViewById(R.id.tvRating)
        private val tvCategory: TextView = itemView.findViewById(R.id.tvCategory)
        private val tvDeliveryTime: TextView = itemView.findViewById(R.id.tvDeliveryTime)
        private val tvDeliveryCost: TextView = itemView.findViewById(R.id.tvDeliveryCost)
        private val tvDiscount: TextView = itemView.findViewById(R.id.tvDiscount)
        private val tvDiscountInfo: TextView = itemView.findViewById(R.id.tvDiscountInfo)

        fun bind(food: Food) {
            imageFood.setImageResource(food.image)
            tvFoodName.text = food.name
            tvRating.text = food.price
            tvCategory.text = food.category
            tvDeliveryTime.text = food.deliveryTime
            tvDeliveryCost.text = food.deliveryCost
            tvDiscount.text = food.discount
            tvDiscountInfo.text = food.discountInfo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(foodList[position])
    }

    override fun getItemCount() = foodList.size
}