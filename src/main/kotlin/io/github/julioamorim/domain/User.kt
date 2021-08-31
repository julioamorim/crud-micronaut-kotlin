package io.github.julioamorim.domain

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue
    val id: Long = 0,
    @Column(name = "name")
    val name: String = "",
    @Column(name = "password")
    val password: String = "",
    @Column(name = "email")
    val email: String = ""
)