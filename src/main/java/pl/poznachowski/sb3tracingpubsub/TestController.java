package pl.poznachowski.sb3tracingpubsub;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestProducer testProducer;

    @GetMapping
    public String send() {
        testProducer.send();
        return "ok";
    }
}

