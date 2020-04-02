package br.com.training.android.restaurantmenu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {
    private var listOfFoods = ArrayList<Food>()
    private var foodAdapter: FoodAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOfFoods.add(Food("Coffee", "A hot drink in a cup", R.drawable.coffee_pot))
        listOfFoods.add(Food("Espresso", "A hot drink in a cup", R.drawable.espresso))
        listOfFoods.add(Food("French fries", "Delicious fries", R.drawable.french_fries))
        listOfFoods.add(Food("Honey", "Natural sugar", R.drawable.honey))
        listOfFoods.add(Food("Ice cream", "Good for hot days", R.drawable.strawberry_ice_cream))
        listOfFoods.add(Food("Sugar cubes", "Horses really like it", R.drawable.sugar_cubes))

        foodAdapter = FoodAdapter(applicationContext, listOfFoods)

        gridViewMenu.adapter = this.foodAdapter
    }

    class FoodAdapter(ctx: Context, listFoods: ArrayList<Food>) : BaseAdapter() {
        private var foods = listFoods
        private var context: Context? = ctx

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val food = this.foods[p0]
            val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val foodView = inflater.inflate(R.layout.food_ticket, null)

            foodView.txtViewFoodName.text = food.name!!

            foodView.imgViewMenuItem.setImageResource(food.image!!)
            foodView.imgViewMenuItem.setOnClickListener {
                val intent = Intent(this.context, FoodDetailsActivity::class.java)

                intent.putExtra("name", food.name)
                intent.putExtra("description", food.description)
                intent.putExtra("image", food.image)
                context!!.startActivity(intent)
            }

            return foodView
        }

        override fun getItem(p0: Int): Any {
            return foods[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return foods.size
        }

    }

}
