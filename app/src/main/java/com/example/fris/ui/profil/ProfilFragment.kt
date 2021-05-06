package com.example.fris.ui.profil

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fris.R
import kotlinx.android.synthetic.main.fragment_profil.*
import kotlinx.android.synthetic.main.fragment_profil.view.*


//TODO: WEBVIEW AV FACEBOOK & NOTIFICATIONS?
class ProfilFragment : Fragment() {

    private lateinit var profilViewModel: ProfilViewModel
    private lateinit var linkTextView : TextView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        profilViewModel = ViewModelProvider(this).get(ProfilViewModel::class.java)

        val view =  inflater.inflate(R.layout.fragment_profil, container, false)

        linkTextView = view.facebook_link

        return view

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        linkTextView.setOnClickListener{
            //NAVIGATE BETWEEN FRAGMENTS
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, WebViewFragment())?.commitNow()
        }

    }



}