package com.example.mvvmrestapikotlinapp.dataclass

data class Movies(
    val page: Int,
    val result: List<Result>,
    val total_psges: Int,
    val total_result: Int
)
