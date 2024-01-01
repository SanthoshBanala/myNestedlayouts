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
import androidx.databinding.DataBindingUtil
import com.example.mynestedlayouts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)
        //setContentView(R.layout.activity_main)
        //findViewById<Button>(R.id.btnToConfirm).setOnClickListener{
        //    addNickname(it)
        //}
        binding.btnToConfirm.setOnClickListener {
            addNickname(it)
        }
    }
    private fun addNickname (view:View){
        binding.textToConfirm.text=binding.enterUrname.text
        binding.enterUrname.visibility=View.GONE
        binding.btnToConfirm.visibility=View.GONE
        binding.textToConfirm.visibility=View.VISIBLE

        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(view.windowToken,0)

    }
}