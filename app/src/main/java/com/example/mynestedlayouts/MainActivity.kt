package com.example.mynestedlayouts

import android.content.Context
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.getSystemService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnToConfirm).setOnClickListener{
            addNickname(it)
        }
    }
    private fun addNickname (view:View){
        val editText = findViewById<EditText>(R.id.enterUrname)
        val nickname = findViewById<TextView>(R.id.textToConfirm)
        nickname.text=editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nickname.visibility = View.VISIBLE

        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(view.windowToken,0)

    }
}