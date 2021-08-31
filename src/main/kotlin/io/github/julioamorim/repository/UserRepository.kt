package io.github.julioamorim.repository

import io.github.julioamorim.domain.User
import io.micronaut.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {

    fun findByEmail(email: String): User?
}