package com.paultamayo.trace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@Slf4j
@SpringBootApplication
public class App {

	private final Tracer tracer;

	@GetMapping("/tracer-info")
	public String tracerInfo() {
		return "Tracer class: " + tracer.getClass().getName();
	}

	@GetMapping("/trace")
	public Mono<String> getTraceId() {
		return Mono.deferContextual(_ -> {
			Span currentSpan = tracer.currentSpan();
			if (currentSpan != null) {
				String traceId = currentSpan.context().traceId();
				return Mono.just("TraceId desde Reactor Context: " + traceId);
			}
			return Mono.just("No hay traceId disponible");
		});
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
