package cn.hik.wujianfei.fieldwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivemqQueueController {

    @Autowired
    private MessageConsumerService consumerService;

    @Autowired
    private MessageProducerService producerService;

    @GetMapping("/queue/produce/{message}")
    public void sendQueue(@PathVariable String message) {
        producerService.produceQueueMessage(message);
    }

    @GetMapping("/topic/produce/{message}")
    public void sendTopic(@PathVariable String message) {
        producerService.produceTopicMessage(message);
    }
}
