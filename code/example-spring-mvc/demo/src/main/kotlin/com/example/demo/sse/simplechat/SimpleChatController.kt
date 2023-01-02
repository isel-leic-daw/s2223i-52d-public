package com.example.demo.sse.simplechat

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.time.Instant
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit
import javax.annotation.PreDestroy

@RestController
class SimpleChatController(
    private val chatService: SimpleChatService
) {

    @GetMapping("api/simplechat/listen")
    fun listen(): SseEmitter {
        logger.info("Listen Called")
        val sseEmitter = chatService.newListener()
        return sseEmitter
    }

    @PostMapping("api/simplechat/send")
    fun send(@RequestBody message: String) {
        logger.info("Chat Send")
        chatService.sendMessage(message)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(SimpleChatController::class.java)
    }
}

data class Message(val id: Long, val msg: String)

@Service
class SimpleChatService {

    private var currentId = 0L
    private var sseEmitter1: SseEmitter? = null
    private var sseEmitter2: SseEmitter? = null

    fun newListener(): SseEmitter {
        logger.info("newListener")
        val sseEmitter = SseEmitter(TimeUnit.MINUTES.toMillis(5))
        if(sseEmitter1 == null) sseEmitter1 = sseEmitter else sseEmitter2 =  sseEmitter
        return sseEmitter
    }

    fun sendMessage(msg: String) {
        logger.info("sendMessage")
        currentId++
        val event = SseEmitter.event()
                        .id(currentId.toString())
                        .name("message")
                        .data(Message(currentId,msg))
        sseEmitter1?.send(event)
        sseEmitter2?.send(event)

    }
    companion object {
        private val logger = LoggerFactory.getLogger(SimpleChatService::class.java)
    }

}
