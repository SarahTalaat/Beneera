package com.example.beneera.util

import com.example.beneera.R

object ImageMapper {
    fun getProductDrawable(imageUrl: String): Int {
        val clean = imageUrl.substringBefore(".").lowercase().replace("-", "_")
        return when {
            clean.contains("hcdzrxsoodyj5qg0hdez") || clean.contains("bed") -> R.drawable.hcdzrxsoodyj5qg0hdez
            clean.contains("fvcuinszpncstzktqibc") || clean.contains("fountain") -> R.drawable.fvcuinszpncstzktqibc
            clean.contains("qg8k7txibft8rwxq24on") || clean.contains("laser") || clean.contains("toy") -> R.drawable.qg8k7txibft8rwxq24on
            clean.contains("kafbb7tvwjpvkzwvjjs7") || clean.contains("grooming") -> R.drawable.kafbb7tvwjpvkzwvjjs7
            clean.contains("w5pobjhvrj8apylm9ccw") || clean.contains("carrier") -> R.drawable.w5pobjhvrj8apylm9ccw
            clean.contains("zso3vfdlkhajfi2r8qdh") || clean.contains("cleaner") -> R.drawable.zso3vfdlkhajfi2r8qdh
            clean.contains("m9x0lamyvmdodgtqce74") || clean.contains("raincoat") -> R.drawable.m9x0lamyvmdodgtqce74
            clean.contains("vgmys1suxkug5tvagpg9") || clean.contains("tree") -> R.drawable.vgmys1suxkug5tvagpg9
            else -> R.drawable.hero_pet_essentials
        }
    }
    
    fun getCategoryDrawable(categoryId: String): Int {
        return when (categoryId) {
            "dog-supplies" -> R.drawable.category_dog_supplies
            "cat-supplies" -> R.drawable.category_cat_supplies
            "pet-grooming" -> R.drawable.category_pet_grooming
            "pet-feeding" -> R.drawable.category_feeding_watering
            "pet-toys" -> R.drawable.category_pet_toys
            "pet-beds" -> R.drawable.category_pet_beds_furniture
            "pet-travel" -> R.drawable.category_travel_carriers
            "pet-cleaning" -> R.drawable.category_cleaning_odor
            else -> R.drawable.category_dog_supplies
        }
    }

    fun getHeroDrawable(): Int {
        return R.drawable.hero_pet_essentials
    }
}
