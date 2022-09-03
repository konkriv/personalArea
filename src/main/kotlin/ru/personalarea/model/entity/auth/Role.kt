//package ru.personalarea.model.entity.auth
//
//import org.springframework.security.core.GrantedAuthority
//import javax.persistence.*
//
//class Role(
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    val id: Long,
//    val userName: String,
//    @Transient
//    @ManyToMany(mappedBy = "roles")
//    val users: Set<User>
//) : GrantedAuthority{
//    override fun getAuthority(): String {
//        TODO("Not yet implemented")
//    }
//}