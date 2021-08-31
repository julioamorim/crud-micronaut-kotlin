package io.github.julioamorim.model

data class UserDTO(
    var name: String? = null,
    var email: String? = null,
    var password: String? = null
) {
    constructor(user: User) : this(
        name = user.name,
        email = user.email
    )

    fun toUse(): User? {
        return if (validade()) {
            User(
                name = name!!,
                email = email!!,
                password = password ?: ""
            )
        }else{
            null
        }
    }

    fun validade() = !name.isNullOrEmpty() || !email.isNullOrEmpty()

}