package com.demo.otelspringgateway.config;

import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.SdkTracerProviderBuilder;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Configuration
public class OpentelemetryConfig {

    /*@Bean
    public SdkTracerProvider sdkTracerProvider(
            ObjectProvider<List<SpanExporter>> spanExportersProvider) {

        SdkTracerProviderBuilder tracerProviderBuilder = SdkTracerProvider.builder();

        spanExportersProvider.getIfAvailable(Collections::emptyList).stream()
                .map(spanExporter -> BatchSpanProcessor.builder(spanExporter).build())
                .forEach(tracerProviderBuilder::addSpanProcessor);

        return tracerProviderBuilder
                //.setResource(resource)
                //.setSampler(new FilterSampler(endpoints, attributes))
                .build();
    }*/
}
