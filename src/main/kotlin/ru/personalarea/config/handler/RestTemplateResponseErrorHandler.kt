package ru.personalarea.config.handler

import org.springframework.context.annotation.Configuration
import org.springframework.http.client.ClientHttpResponse
import org.springframework.web.client.DefaultResponseErrorHandler

@Configuration
class RestTemplateResponseErrorHandler : DefaultResponseErrorHandler() {

    override fun handleError(response: ClientHttpResponse) {
        if(response.statusCode.value() == 401){
            print("Тут будет обработка 401 ошибки")
        }
        super.handleError(response)
    }
}