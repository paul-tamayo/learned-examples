package com.paultamayo.trace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@Slf4j
@SpringBootApplication
public class App {

	private final Tracer tracer;

	@GetMapping("/")
	public String home() {
		Span span = Span.current();

		String traceId = span.getSpanContext().getTraceId();
		String spanId = span.getSpanContext().getSpanId();
		log.info("Procesando demo con traceId={} spanId={}", traceId, spanId);

		return "Hello World!";
	}

	@GetMapping("/webflux")
	public Mono<String> demo() {
		Span span = tracer.spanBuilder("demo").startSpan();

		return Mono.deferContextual(_ -> {
			Span currentSpan = Span.current();
			String traceId = currentSpan.getSpanContext().getTraceId();
			String spanId = currentSpan.getSpanContext().getSpanId();

			log.info("Procesando WebFlux con traceId={} spanId={}", traceId, spanId);

			return Mono.just("TraceId actual: " + traceId);
		}).doFinally(_ -> span.end());
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
