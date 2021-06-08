package com.example.fris.ui.profil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fris.R
import kotlinx.android.synthetic.main.web_view_fragment.view.*


class WebViewFragment : Fragment() {

    private lateinit var webviewModel: WebViewViewModel
    private lateinit var webView: WebView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.web_view_fragment, container, false)

        webView = view.web_view
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.facebook.com/")
        WebView.setWebContentsDebuggingEnabled(false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        webviewModel = ViewModelProvider(this).get(WebViewViewModel::class.java)
        // TODO: Use the ViewModel
    }

}