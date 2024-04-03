package com.example.myapplication.model

import android.os.Parcel
import android.os.Parcelable

//data class Animal(
//    val name: String,
//    val taxonomy: Taxonomy,
//    val locations: ArrayList<String>,
//    val characteristics: Characteristics,
//)
data class Animal(
    val name: String?,
    val taxonomy: Taxonomy?,
    val locations: List<String>,
    val characteristics: Characteristics?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readParcelable(Taxonomy::class.java.classLoader),
        arrayListOf<String>().apply{
            parcel.readList(this, String::class.java.classLoader)
        },
        parcel.readParcelable(Characteristics::class.java.classLoader)
    ){}
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeParcelable(taxonomy, flags)
        parcel.writeList(locations)
        parcel.writeParcelable(characteristics, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Animal> {
        override fun createFromParcel(parcel: Parcel): Animal {
            return Animal(parcel)
        }

        override fun newArray(size: Int): Array<Animal?> {
            return arrayOfNulls(size)
        }
    }
}
