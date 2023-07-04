package pl.poznachowski.sb3tracingpubsub;

import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.config.ConsumerEndpointCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.endpoint.MessageProducerSupport;

@SpringBootApplication
@RequiredArgsConstructor
public class Sb3TracingPubsubApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sb3TracingPubsubApplication.class, args);
    }

    @Bean
    ConsumerEndpointCustomizer<MessageProducerSupport> consumerEndpointCustomizer(
            ObservationRegistry observationRegistry) {

        return (endpoint, destinationName, group) -> endpoint.registerObservationRegistry(observationRegistry);
    }

}
