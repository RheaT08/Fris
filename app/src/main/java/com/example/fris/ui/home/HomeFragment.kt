package com.example.fris.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fris.DessertActivity
import com.example.fris.MyAdapter
import com.example.fris.R
import com.example.fris.database.Dessert
import kotlinx.android.synthetic.main.dessert_cardview.*
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    //ADAPTER & RECYCLERVIEW
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var dessertAdapter: MyAdapter



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

       // val cardView: CardView = findViewById(R.id.card_view)
       // card_view.setOnClickListener {
        // val activityIntent = Intent(activity, DessertActivity::class.java)
         //   startActivity(activityIntent) //viderefører brukeren
        //}

        return root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayMeny(menu())
    }



    //TODO: Scroll horizontally
    private fun displayMeny(dessertMenu: MutableList<Dessert>){


        viewManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false) //Make recyclerview scroll sideways.
        viewAdapter = MyAdapter({},dessertMenu)  //legger inn listen min av dessert (Menyen) mates inn i recyclerview/adapter
        //Lag egen cardviewlistener, hva som skjer osv når cardview trykkes.

        recyclerView = dessert_recyclerview.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            //adapter = viewAdapter
            dessert_recyclerview.adapter = viewAdapter
        }


    }


    //Manuelt lager Dessert-objektene
    private fun menu() : MutableList<Dessert> {

        //Oppretter dessert-objektene manuelt her
        val des1 = Dessert(
            "1",
            "Sjokolade Rolled ice-cream",
            "@strings/icecream_description",
            "Kokos, Kakao", "69 kr",
            "@drawable/image_10"
        )

        val des2 = Dessert(
            "2",
            "Vanilje Rolled ice-cream",
            "@strings/icecream_description",
            "Kokos, Vanilje", "69 kr",
            "@drawable/image_10"
        )

        val des3 = Dessert(
            "3",
            "Skogsbær Rolled ice-cream",
            "@strings/icecream_description",
            "Kokos, blåbær, bringebær, bjørnebøær", "69 kr",
            "@drawable/image_10"
        )

        val des4 = Dessert(
            "4",
            "Skogsbær Rolled ice-cream",
            "@strings/icecream_description",
            "Kokos, jordbær", "69 kr",
            "@drawable/image_10"
        )


        val rolledIceCreamMeny : MutableList<Dessert> = mutableListOf(des1, des2, des3, des4)
        return rolledIceCreamMeny

    }

}