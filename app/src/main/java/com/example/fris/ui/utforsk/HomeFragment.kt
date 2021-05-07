package com.example.fris.ui.utforsk

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fris.DessertActivity
import com.example.fris.MyAdapter
import com.example.fris.R
import com.example.fris.database.Dessert
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {


    private lateinit var homeViewModel: HomeViewModel

    //ADAPTER & RECYCLERVIEW
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var dessertAdapter: MyAdapter

    //NOTIFICATIONS
    private lateinit var notificationBtn : Button
    private lateinit var notificationManager : NotificationManager
    private val channelId = "com.rhea.fris.important.notifications"
    private var counter = 0

    companion object {

         var valgt_iskrem = "0"

        //Manuelt lager Dessert-objektene
        fun menu() : MutableList<Dessert> {

            //Oppretter dessert-objektene manuelt her
            val des1 = Dessert(
                    "1",
                    "Sjokolade Rolled ice-cream",
                    "@strings/icecream_description",
                    "Kokos, Kakao", "69 kr", R.drawable.image_10

            )

            val des2 = Dessert(
                    "2",
                    "Vanilje Rolled ice-cream",
                    "@strings/icecream_description",
                    "Kokos, Vanilje", "69 kr", R.drawable.image_8
            )

            val des3 = Dessert(
                    "3",
                    "Skogsbær Rolled ice-cream",
                    "@strings/icecream_description",
                    "Kokos, blåbær, bringebær, bjørnebøær", "69 kr",
                    R.drawable.image_7
            )

            val des4 = Dessert(
                    "4",
                    "Jordbær Rolled ice-cream",
                    "@strings/icecream_description",
                    "Kokos, jordbær", "69 kr",
                    R.drawable.image_9
            )


            val rolledIceCreamMeny : MutableList<Dessert> = mutableListOf(des1, des2, des3, des4)
            return rolledIceCreamMeny

        }


        fun getDessert(id_en: String) : Dessert{
            val list = menu()  //gir meg menyListen
            lateinit var iskremen : Dessert

            for(iskrem in list){
                if(iskrem.id == id_en){
                    iskremen = iskrem
                }
            }
            return iskremen
        }

    }//end of companion object


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)


        return root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //sette notification her
        notificationManager = requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel()

        notification_btn.setOnClickListener {
            createAndSendNotification()
        }

        displayMeny(menu())

    }




    private fun displayMeny(dessertMenu: MutableList<Dessert>){


        viewManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false) //Make recyclerview scroll sideways.
        viewAdapter = MyAdapter(requireContext(), { cardOnClick() }, dessertMenu) //cardOnClick callback, håndterer når du trykker på spesifikk kort.
                                                                                //legger inn listen min av dessert (Menyen) mates inn i recyclerview/adapter




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

    //Lag egen cardviewlistener, hva som skjer osv når cardview (eller i dette tilfellet textview, imageview) trykkes
    private fun cardOnClick(){
        valgt_iskrem = "3"  //TODO: Finne ut hvordan Myadapter sender Dessert-objekt tilbake. Så du kan inhente id-en her.
        val activityIntent = Intent(requireContext(), DessertActivity::class.java)  //send iskrem id.
        startActivity(activityIntent)
    }


    //NOTIFICATIONS

    //Her lager vi egen channel for notifications lokalt.
    @SuppressLint("NewApi")
    private fun createNotificationChannel(){

        val channel = NotificationChannel(channelId, "Handlekurv er fylt!", NotificationManager.IMPORTANCE_HIGH)

        channel.description = "Når du har varer i din handlekurv"
       // channel.enableLights(false)
       // channel.lightColor = Color.BLUE
        channel.enableVibration(true)
        channel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)

        notificationManager.createNotificationChannel(channel) // her oppretter/sender vi kanalen vår i NotificationManager-klassen

    }


    @SuppressLint("NewApi")
    private fun createAndSendNotification(){

        val notificationId = counter

        val notification = Notification.Builder(activity, channelId)
                .setContentTitle("Hei der!")
                .setContentText("Rolled ice-cream står i din handlekurv.")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .build()

        notificationManager.notify(notificationId, notification)
        counter++
    }

}