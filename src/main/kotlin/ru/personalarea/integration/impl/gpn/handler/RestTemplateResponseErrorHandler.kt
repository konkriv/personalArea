package ru.personalarea.integration.impl.gpn.handler

import org.springframework.http.HttpHeaders
import org.springframework.http.client.ClientHttpResponse
import org.springframework.web.client.DefaultResponseErrorHandler
import ru.personalarea.repository.SessionRepository

class RestTemplateResponseErrorHandler(
    private val headers: HttpHeaders,
    private val repo: SessionRepository,
    private val login: String
) : DefaultResponseErrorHandler() {

    override fun handleError(response: ClientHttpResponse) {
        if (response.statusCode.value() == 401) {
            val session = repo.findSessionByLogin(login)
            session.sessionId =
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjY0NGI4NTRhODU5YjIxZDllNWEwOTU5YmZmNGY1YTNhY2I5NzEzOWJmNDA4MzFlM2I1MTA1YzU3ODQ5Zjc3ZDgyZTAxOWM0MDhmNzdlMzhiIn0.eyJhdWQiOiI1ZWNhZjViMTkyZmNlNzMyZjk1ODQyNjIiLCJqdGkiOiI2NDRiODU0YTg1OWIyMWQ5ZTVhMDk1OWJmZjRmNWEzYWNiOTcxMzliZjQwODMxZTNiNTEwNWM1Nzg0OWY3N2Q4MmUwMTljNDA4Zjc3ZTM4YiIsImlhdCI6MTYzMTkxMjQyNSwibmJmIjoxNjMxOTEyNDI1LCJleHAiOjE2MzQ1MDQ0MjUsInN1YiI6IjYxNDRmMDQ1OGU2N2ExN2E5YjRiNTc4YyIsInNjb3BlcyI6W119.R10t2U0H6RmTODc7L8d-J_Cc7gA8Ti72e7A0rS6FFMWxNuXKL8oFop_Z0vtWsIH53xhj5JquHE3i9YsifjS5mA"
            headers.set("session_id", session.sessionId)
            repo.save(session)
        }
        super.handleError(response)
    }
}