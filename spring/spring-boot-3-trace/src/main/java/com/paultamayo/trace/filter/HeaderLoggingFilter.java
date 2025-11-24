package com.paultamayo.trace.filter;

import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import io.opentelemetry.api.trace.Span;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Order(-1)
@Slf4j
public class HeaderLoggingFilter implements WebFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
		return chain.filter(exchange).contextWrite(ctx -> {
			Span currentSpan = Span.current();
			if (currentSpan != null && currentSpan.getSpanContext().isValid()) {
				MDC.put("traceId", currentSpan.getSpanContext().getTraceId());
				MDC.put("spanId", currentSpan.getSpanContext().getSpanId());
			}
			return ctx;
		}).doFinally(_ -> MDC.clear());
	}

}
