package com.example.parcelable_pass_arraylistobject_to_activity2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExampleAdaptor(var c:Context, var l: ArrayList<CardData>?): RecyclerView.Adapter<ExampleAdaptor.ExampleViewHolder>() {

 protected var listener:OnclickListener? = null

    interface  OnclickListener{
        fun onClick(position:Int)
    }

    fun setOnClickListener(listener:OnclickListener){
        this.listener = listener
    }

    class ExampleViewHolder : RecyclerView.ViewHolder{
        var tv:TextView? = null
        var iv:ImageView?= null

        constructor(v:View,listener: OnclickListener):super(v){
            tv = v.findViewById(R.id.card_tv_Image_title)
            iv = v.findViewById(R.id.card_iv)
            var l = listener

            v.setOnClickListener{
                if (l!=null){
                var p = adapterPosition
                    if (p != RecyclerView.NO_POSITION) {
                        l.onClick(p)

                    }
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        var inflater = LayoutInflater.from(c)
        var v = inflater.inflate(R.layout.cardview,parent,false)
        return ExampleViewHolder(v,listener!!)
    }

    override fun getItemCount(): Int {
        return l!!.size

    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {

        var cardData = l?.get(position)
        holder.tv?.setText(cardData?.title)
        holder.iv?.setImageResource(cardData?.uri!!)
    }



}