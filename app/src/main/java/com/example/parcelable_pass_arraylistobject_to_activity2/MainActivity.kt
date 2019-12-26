package com.example.parcelable_pass_arraylistobject_to_activity2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ExampleAdaptor.OnclickListener{
var list:ArrayList<CardData>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        list = ArrayList()
        list?.add(CardData("Image1", R.drawable.image1))
        list?.add(CardData("Image2", R.drawable.image2))
        list?.add(CardData("image3", R.drawable.image3))
        list?.add(CardData("image4", R.drawable.image4))
        list?.add(CardData("image5", R.drawable.image5))

        var adaptor = ExampleAdaptor(this, list)

        adaptor.setOnClickListener(this)

        rv.adapter = adaptor

    }

    override fun onClick(position: Int) {
       var i = Intent(this,Activity2::class.java)
        i.putExtra("CardData",list?.get(position))
        startActivity(i)
    }

}
