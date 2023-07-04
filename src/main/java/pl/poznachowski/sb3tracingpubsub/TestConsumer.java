package pl.poznachowski.sb3tracingpubsub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
public class TestConsumer {

    @Bean
    Consumer<Message<TestEvent>> onArrival() {
        return testEventMessage -> {
            var payload = testEventMessage.getPayload();
            log.info("Event came: {}", payload);
        };
    }
}
