package com.example.ejercicio9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Solo ponerlo si no los añade Android
        var b1 = findViewById<Button>(R.id.b1)
        var et1 = findViewById<EditText>(R.id.et1)
        var et2 = findViewById<EditText>(R.id.et2)

        //Apartado1
        var textWatcher = object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (et1.text.isNotEmpty() && et2.text.isNotEmpty()){
                    b1.isEnabled = true
                }
            }
        }

        et1.addTextChangedListener(textWatcher)
        et2.addTextChangedListener(textWatcher)

        //Apartado2
        b1.setOnClickListener{
            et1.text.append(et2.text.toString())
            et2.text.clear()
        }

        //Apartado3
        var focusListener = View.OnFocusChangeListener { vista, isFocus ->
            if (isFocus) tv1.text = vista.tag.toString()
        }

        et1.onFocusChangeListener = focusListener
        et2.onFocusChangeListener = focusListener
        b1.onFocusChangeListener = focusListener
    }
}