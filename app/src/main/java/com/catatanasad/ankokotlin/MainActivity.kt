package com.catatanasad.ankokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout

import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)


        // todo 1 buat linear layout vertical
        verticalLayout {
            lparams {
                padding = 16
                width = matchParent
                height = wrapContent
            }

            // todo 2 untuk menampilkan edit text dan mengambil nilai dari edittext
            var inputan1 = editText{
                hint = "Masukkan angka"
            }
            var inputan2 = editText {
                hint = "Masukkan angka"
            }

            linearLayout {
                orientation = LinearLayout.HORIZONTAL

                // todo 3 untuk menampilkan dan memberi fungsi button
                button("Tambah"){
                    setOnClickListener {
                        actionHitung("+", inputan1.text.toString(), inputan2.text.toString())
                    }
                }.lparams(width = wrapContent)

                // todo 3 untuk menampilkan dan memberi fungsi button
                button("Kurang"){
                    setOnClickListener {
                        actionHitung("-",  inputan1.text.toString(), inputan2.text.toString())
                    }
                }.lparams(width = wrapContent)

                // todo 3 untuk menampilkan dan memberi fungsi button
                button("Bagi"){
                    setOnClickListener {
                        actionHitung(":",  inputan1.text.toString(), inputan2.text.toString())
                    }
                }.lparams(width = wrapContent)

                // todo 3 untuk menampilkan dan memberi fungsi button
                button("Kali"){
                    setOnClickListener {
                        actionHitung("*",  inputan1.text.toString(), inputan2.text.toString())
                    }
                }.lparams(width = wrapContent)
            }
        }
    }

    // todo 4 function untuk opearasi aritmatika
    fun actionHitung(operator : String, text1 : String, text2 : String){

        if(text1.isNotEmpty() && text2.isNotEmpty()){

            val conv1 = text1.toDouble()
            val conv2 = text2.toDouble()

            var hasil : Double? = null

            when(operator){
                "+" -> hasil = conv1 + conv2
                "-" -> hasil = conv1 - conv2
                ":" -> hasil = conv1 / conv2
                "*" -> hasil = conv1 * conv2
                else -> {
                    toast("tidak ada")
                }
            }

            toast(hasil.toString())

        }
    }


}
