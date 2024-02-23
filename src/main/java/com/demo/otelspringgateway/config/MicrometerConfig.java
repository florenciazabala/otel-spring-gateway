package com.demo.otelspringgateway.config;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationPredicate;
import io.micrometer.observation.ObservationView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.observation.ServerRequestObservationContext;

@Configuration
public class MicrometerConfig {

    /*@Bean
    public ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
        observationRegistry.observationConfig().observationHandler(new SimpleLoggingHandler());

        return new ObservedAspect(observationRegistry);
    }*/

    private Observation.Context getRoot(Observation.Context current) {
        ObservationView parent = current.getParentObservation();
        if (parent == null) {
            return current;
        } else {
            return getRoot((Observation.Context) parent.getContextView());
        }
    }

    @Bean
    ObservationPredicate noActuatorServerObservations() {
        return (name, context) -> {
            Observation.Context root = getRoot(context);
            if (root instanceof ServerRequestObservationContext serverContext) {
                return !serverContext.getCarrier().getPath().value().startsWith("/health");
            } else {
                return true;
            }
        };
    }
}
