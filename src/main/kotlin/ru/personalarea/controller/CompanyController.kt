//package ru.personalarea.controller
//
//import org.springframework.stereotype.Controller
//import org.springframework.ui.Model
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.PathVariable
//import ru.personalarea.repository.CompanyRepository
//import javax.persistence.EntityManager
//
//
//@Controller
//class CompanyController(
//    private val em: EntityManager,
//    private val repo: CompanyRepository
//) {
//    @GetMapping("/companies")
//    fun getCompanies(model: Model): String {
//        val companies = repo.findAll()
//        model.addAttribute("companies", companies)
//        return "companies"
//    }
//
//    @GetMapping("/companiesWithCards")
//    fun getCompaniesWithCards(model: Model): String {
//        val query = em.createQuery("select distinct company from Company company  left join fetch company.cards cards")
//        val companies = query.resultList
//        model.addAttribute("companies", companies)
//        return "companies"
//    }
//
//    @GetMapping("/companies/{companyId}")
//    fun getCompanyById(@PathVariable(required = false) companyId: Long, model: Model): String {
//        val company = repo.findCompanyById(companyId)
//        model.addAttribute("company", company)
//        return "company"
//    }
//
//    @GetMapping("/companiesWithCards/{companyId}")
//    fun getCompanyWithCards(@PathVariable(required = false) companyId: Long, model: Model): String {
//        val query = em.createQuery("select distinct company from Company company left join fetch company.cards cards where company.id = :id")
//        query.setParameter("id", companyId)
//        val company = query.singleResult
//        model.addAttribute("company", company)
//        return "company"
//    }
//}