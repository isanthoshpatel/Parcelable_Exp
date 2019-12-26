package com.example.parcelable_pass_arraylistobject_to_activity2

import android.os.Parcel
import android.os.Parcelable

class CardData: Parcelable {

    var title:String? = null
    var uri:Int? = null

    constructor(title:String,uri:Int){
        this.title = title
        this.uri = uri
    }

    constructor(parcel: Parcel){
        title = parcel.readString()
        uri = parcel.readInt()
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeInt(uri!!)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CardData> {
        override fun createFromParcel(parcel: Parcel): CardData {
            return CardData(parcel)
        }

        override fun newArray(size: Int): Array<CardData?> {
            return arrayOfNulls(size)
        }
    }
}