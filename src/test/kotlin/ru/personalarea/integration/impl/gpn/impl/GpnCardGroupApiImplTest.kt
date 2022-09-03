package ru.personalarea.integration.impl.gpn.impl

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.personalarea.integration.impl.gpn.GpnCardGroupApi

@SpringBootTest
internal class GpnCardGroupApiImplTest(
    @Autowired val gpnApi: GpnCardGroupApi
) {

    @Test
    fun getCardGroups() {
        val result = (gpnApi.getCardGroups("1-6Y7NH1W"))
        println(result.body?.data)
    }
}