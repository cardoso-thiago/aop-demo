package br.com.cardoso.interceptor

import br.com.cardoso.annotation.Log
import io.micronaut.aop.InterceptorBean
import io.micronaut.aop.MethodInterceptor
import io.micronaut.aop.MethodInvocationContext
import io.micronaut.http.HttpHeaders
import javax.inject.Singleton

@Singleton
@InterceptorBean(Log::class)
class LogInterceptor : MethodInterceptor<Any, Any> {

    override fun intercept(context: MethodInvocationContext<Any, Any>): Any {
        for(param in context.parameterValues){
            if(param is HttpHeaders){
                for(header in param.asMap()){
                    println("${header.key} => ${header.value}")
                }
            }
        }
        return context.proceed()
    }
}