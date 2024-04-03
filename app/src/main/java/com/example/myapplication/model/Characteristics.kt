package com.example.myapplication.model

import android.os.Parcel
import android.os.Parcelable

data class Characteristics(
    val prey: String?,
    val name_of_young: String?,
    val group_behavior: String?,
    val estimated_population_size: String?,
    val biggest_threat: String?,
    val most_distinctive_feature: String?,
    val gestation_period: String?,
    val habitat: String?,
    val diet: String?,
    val average_litter_size: String?,
    val lifestyle: String?,
    val common_name: String?,
    val number_of_species: String?,
    val location: String?,
    val slogan: String?,
    val group: String?,
    val color: String?,
    val skin_type: String?,
    val top_speed: String?,
    val lifespan: String?,
    val weight: String?,
    val height: String?,
    val age_of_sexual_maturity: String?,
    val age_of_weaning: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(prey)
        parcel.writeString(name_of_young)
        parcel.writeString(group_behavior)
        parcel.writeString(estimated_population_size)
        parcel.writeString(biggest_threat)
        parcel.writeString(most_distinctive_feature)
        parcel.writeString(gestation_period)
        parcel.writeString(habitat)
        parcel.writeString(diet)
        parcel.writeString(average_litter_size)
        parcel.writeString(lifestyle)
        parcel.writeString(common_name)
        parcel.writeString(number_of_species)
        parcel.writeString(location)
        parcel.writeString(slogan)
        parcel.writeString(group)
        parcel.writeString(color)
        parcel.writeString(skin_type)
        parcel.writeString(top_speed)
        parcel.writeString(lifespan)
        parcel.writeString(weight)
        parcel.writeString(height)
        parcel.writeString(age_of_sexual_maturity)
        parcel.writeString(age_of_weaning)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Characteristics> {
        override fun createFromParcel(parcel: Parcel): Characteristics {
            return Characteristics(parcel)
        }

        override fun newArray(size: Int): Array<Characteristics?> {
            return arrayOfNulls(size)
        }
    }
}
