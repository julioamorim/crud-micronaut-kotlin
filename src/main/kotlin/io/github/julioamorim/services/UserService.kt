package io.github.julioamorim.services

import io.github.julioamorim.model.Response
import io.github.julioamorim.model.UserDTO

interface UserService {

    fun saveUser(user: UserService, response: Response<UserDTO>)

    fun delete(userId: Long, response: Response<UserDTO>)

    fun findAll(response: Response<List<UserDTO>>)

    fun findById(userId: Long, response: Response<UserDTO>)
}