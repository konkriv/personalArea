//package ru.personalarea.model.entity.auth
//
//import org.springframework.security.core.GrantedAuthority
//import org.springframework.security.core.userdetails.UserDetails
//import javax.persistence.*
//import javax.persistence.GenerationType.IDENTITY
//
//@Entity
//@Table(name = "users")
//data class User (
//    @Id
//    @GeneratedValue(strategy = IDENTITY)
//    val id: Long,
//    val userName: String,
//    val pass: String,
//    @ManyToMany(fetch = FetchType.EAGER)
//    val roles: Set<Role>
//) : UserDetails
//{
//    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
//       return roles
//    }
//
//    override fun getPassword(): String {
//        return pass
//    }
//
//
//    override fun getUsername(): String {
//        return userName
//    }
//
//    override fun isAccountNonExpired(): Boolean {
//        return true
//    }
//
//    override fun isAccountNonLocked(): Boolean {
//        return true
//    }
//
//    override fun isCredentialsNonExpired(): Boolean {
//        return true
//    }
//
//    override fun isEnabled(): Boolean {
//        return true
//    }
//}