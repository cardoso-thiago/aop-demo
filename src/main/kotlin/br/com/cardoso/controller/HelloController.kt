package br.com.cardoso.controller

import br.com.cardoso.annotation.Log
import io.micronaut.http.HttpHeaders
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller
open class HelloController {

    @Log
    @Get
    open fun hello(headers: HttpHeaders) = "Hello!"
}