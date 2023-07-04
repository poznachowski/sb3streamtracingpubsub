package pl.poznachowski.sb3tracingpubsub;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestProducer {

    private final StreamBridge streamBridge;

    public void send() {
        log.info("Sending EVENT");
        streamBridge.send("sendTest-out-0", new TestEvent("id1", "value"));
    }

}
