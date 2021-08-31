package io.github.julioamorim.repository

import io.github.julioamorim.domain.User
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface UserRepository : CrudRepository<User, Long> {

    fun findByEmail(email: String): User?
}