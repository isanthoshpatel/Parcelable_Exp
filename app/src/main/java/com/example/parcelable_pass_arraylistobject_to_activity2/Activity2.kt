package com.example.parcelable_pass_arraylistobject_to_activity2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_2.*

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        var i = intent

        var carddata = i.getParcelableExtra<CardData>("CardData")

        activity2_tv.setText(carddata.title)
        activity2_iv.setImageResource(carddata.uri!!)
    }
}
