package com.example.demo.pipeline


import org.springframework.util.StopWatch
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory

// singleton
class WatchInterceptor : HandlerInterceptor {

    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any): Boolean {
        val sw = StopWatch()
        sw.start()
        request.setAttribute("my-stop-watch", sw)
        log.info("Before calling $handler (${handler.javaClass.name})")
        if(handler is HandlerMethod) {
            log.info("Before calling ${handler.method.name}")
        }
        return true
    }

    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any, modelAndView: ModelAndView?) {
        val sw = request.getAttribute("my-stop-watch") as StopWatch
        sw.stop()

        log.info("After calling $handler, t=${sw.totalTimeMillis}")
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(WatchInterceptor::class.java)
    }
}