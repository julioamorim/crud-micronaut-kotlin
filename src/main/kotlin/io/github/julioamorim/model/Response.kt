package io.github.julioamorim.model

data class Response<T>(
    var response: T? = null
) {
    val errors = ArrayList<String>()
}