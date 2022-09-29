package com.example.demo.pipeline

import javax.servlet.FilterChain
import javax.servlet.http.HttpFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ExampleFilter : HttpFilter() {

    override fun doFilter(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        log.info("doFilter: before chain call")
        chain.doFilter(request, response)
        log.info("doFilter: after chain call")
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(ExampleFilter::class.java)
    }
}