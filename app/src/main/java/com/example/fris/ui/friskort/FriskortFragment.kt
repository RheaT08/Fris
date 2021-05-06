package com.example.fris.ui.friskort

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fris.R

//TODO: HARDWARE KRAV - WEBVIEW
class FriskortFragment : Fragment() {

    private lateinit var friskortViewModel: FriskortViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        friskortViewModel =
            ViewModelProvider(this).get(FriskortViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_friskort, container, false)

        friskortViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        return root
    }
}