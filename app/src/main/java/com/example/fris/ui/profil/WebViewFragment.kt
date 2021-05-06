package com.example.fris.ui.profil

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.example.fris.R
import kotlinx.android.synthetic.main.web_view_fragment.view.*

class WebViewFragment : Fragment() {

    private lateinit var webviewModel: WebViewViewModel
    private lateinit var webView: WebView


    private lateinit var viewModel: WebViewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.web_view_fragment, container, false)

        webView = view.webview
        webView.loadUrl("https://www.facebook.com/")


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WebViewViewModel::class.java)
        // TODO: Use the ViewModel
    }

}