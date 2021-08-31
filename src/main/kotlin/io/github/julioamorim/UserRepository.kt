package io.github.julioamorim

import io.github.julioamorim.domain.User
import io.micronaut.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {

    fun findByEmail(email: String): User?
}