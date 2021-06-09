package com.example.fris

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fris.ui.utforsk.HomeFragment
import kotlinx.android.synthetic.main.activity_dessert.*


class DessertFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_dessert, container, false)

        //dessertDetails()


        return view
    }


    @SuppressLint("SetTextI18n")
    fun dessertDetails(){

        val dessertObject = HomeFragment.getDessert(HomeFragment.valgt_iskrem)
        dessert_pic.setImageResource(dessertObject.bilde)
        innhold_textview.text = "Innhold: " + dessertObject.innhold
        pris_textview.text = "Pris: " + dessertObject.pris

    }
}