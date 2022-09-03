//package ru.personalarea.controller
//
//import org.springframework.http.HttpStatus
//import org.springframework.http.HttpStatus.NOT_FOUND
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.PathVariable
//import org.springframework.web.bind.annotation.RestController
//import ru.personalarea.controller.exception.IdNotFoundException
//import ru.personalarea.model.entity.CompanyDto
//import ru.personalarea.repository.CompanyRepository
//import java.util.*
//import javax.persistence.EntityManager
//
//
//@RestController
//class CompanyControllerRestApi(
//    private val em: EntityManager,
//    private val repo: CompanyRepository,
//) {
//
//    @GetMapping("/companies", produces = ["application/json;charset=utf-8"])
//    fun getCompanies(): MutableIterable<CompanyDto> = repo.findAll()
//
//    @GetMapping("/companies/{companyId}", produces = ["application/json;charset=utf-8"])
//    fun getCompanyById(@PathVariable companyId: Long): CompanyDto {
//       return repo.findCompanyById(companyId) ?: throw IdNotFoundException("Ошибка: Компания с id $companyId не найдена")
//    }
//
////    @GetMapping("/companies/{companyId}", produces = ["application/json;charset=utf-8"])
////    fun getCompanyById(@PathVariable companyId: Long) :ResponseEntity<Optional<CompanyDto>>{
////        return if (repo.existsById(companyId)){
////            ResponseEntity(repo.findById(companyId), HttpStatus.OK)
////        } else {
////             ResponseEntity(NOT_FOUND)
////        }
////    }
//
//    @GetMapping("/companiesWithCards", produces = ["application/json;charset=utf-8"])
//    fun getCompaniesWithCards(): List<*> {
//        val query = em.createQuery("select distinct company from CompanyDto company  left join fetch company.cards cards")
//        return query.resultList
//    }
//
//    @GetMapping("/companiesWithCards/{companyId}", produces = ["application/json;charset=utf-8"])
//    fun getCompanyWithCards(@PathVariable(required = false) companyId: Long): Any {
//        val query = em.createQuery(
//            "select distinct company from CompanyDto company left join fetch company.cards cards where company.id = :id"
//        )
//        query.setParameter("id", companyId)
//        return query.singleResult
//    }
//}