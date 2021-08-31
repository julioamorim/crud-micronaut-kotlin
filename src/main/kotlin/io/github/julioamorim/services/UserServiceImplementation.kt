package io.github.julioamorim.services

import io.github.julioamorim.domain.User
import io.github.julioamorim.model.Response
import io.github.julioamorim.model.UserDTO
import io.github.julioamorim.repository.UserRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class UserServiceImplementation : UserService {

    @Inject
    lateinit var userRepository: UserRepository;

    override fun saveUser(
        user: User,
        response: io.github.julioamorim.model.Response<io.github.julioamorim.model.UserDTO>
    ) {
        val tempUser = userRepository.findByEmail(user.email)

        if (tempUser != null) {
            response.errors.add("Already registered User")
            return
        }

        userRepository.apply {
            save(user)
            findByEmail(user.email)?.let {
                response.response = UserDTO(it)
            }
        }
    }

    override fun delete(userId: Long, response: Response<UserDTO>) {
        userRepository.deleteById(userId)
    }

    override fun findAll(response: Response<List<UserDTO>>) {
        val userList = userRepository.findAll().map { UserDTO(it) }
        response.response = userList
    }

    override fun findById(userId: Long, response: Response<UserDTO>) {
        val user = userRepository.findById(userId)
        if (user.isPresent) {
            response.response = UserDTO(user.get())
        } else {
            response.errors.add("Invalid Id")
        }
    }


}