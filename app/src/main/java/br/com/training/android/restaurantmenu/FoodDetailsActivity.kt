package br.com.training.android.restaurantmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food_details.*

class FoodDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)

        val bundle = intent.extras

        imgViewFoodDetail.setImageResource(bundle!!.getInt("image"))
        txtViewFoodNameDetail.text = bundle.getString("name")
        txtViewFoodDetail.text = bundle.getString("description")
    }
}
