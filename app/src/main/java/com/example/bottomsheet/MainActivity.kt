package com.example.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.bottomsheet.databinding.ActivityMainBinding
import com.example.bottomsheet.databinding.BottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    lateinit var v: ActivityMainBinding
    lateinit var d: BottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        v = ActivityMainBinding.inflate(layoutInflater)
        setContentView(v.root)

        d = BottomSheetBinding.inflate(layoutInflater)

        val dialog = BottomSheetDialog(this)
        dialog.setContentView(d.root)

        calculate(dialog)

        v.btn.setOnClickListener {

            d.Nums.setText(v.numText.text.toString())
            dialog.show()
        }
    }

    private fun calculate(dialog: BottomSheetDialog) {

        var i = d.Nums.text.toString().toInt()

        d.btnAdd.setOnClickListener {

            i++
            d.Nums.setText(i.toString())
        }

        d.btnRemove.setOnClickListener {

            i--
            d.Nums.setText(i.toString())
        }

        d.confirmButton.setOnClickListener {

            i = d.Nums.text.toString().toInt()
            v.numText.text = i.toString()
            dialog.dismiss()
        }
    }
}