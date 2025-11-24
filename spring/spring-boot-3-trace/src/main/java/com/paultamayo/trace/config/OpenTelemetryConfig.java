package com.paultamayo.trace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.sdk.OpenTelemetrySdk;

@Configuration
public class OpenTelemetryConfig {

	@Bean
	OpenTelemetry openTelemetry() {
		return OpenTelemetrySdk.builder()
				.setPropagators(ContextPropagators.create(W3CTraceContextPropagator.getInstance())).build();
	}

	@Bean
	Tracer tracer(OpenTelemetry openTelemetry) {
		return openTelemetry.getTracer("demo");
	}
}
