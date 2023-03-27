package com.example.mvvmrestapikotlinapp.dataclass

data class Result(
    val adult: Boolean,
    val backdrop_path :String,
    val generate_Id :List<Int>,
    val id : Int,
    val Origional_Language:String,
    val Origional_tital: String,
    val overview: String,
    val popularity :String,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)
