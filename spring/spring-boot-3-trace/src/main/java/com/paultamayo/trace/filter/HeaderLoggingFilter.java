package com.paultamayo.trace.filter;

import java.util.List;
import java.util.Map;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.context.propagation.TextMapGetter;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Order(-1)
@Slf4j
public class HeaderLoggingFilter implements WebFilter {

	private final ContextPropagators propagators = ContextPropagators.create(W3CTraceContextPropagator.getInstance());

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
		Context extractedContext = propagators.getTextMapPropagator().extract(Context.current(),
				exchange.getRequest().getHeaders(), new TextMapGetter<org.springframework.http.HttpHeaders>() {
					@Override
					public Iterable<String> keys(org.springframework.http.HttpHeaders carrier) {
						return carrier.keySet();
					}

					@Override
					public String get(org.springframework.http.HttpHeaders carrier, String key) {
						return carrier.getFirst(key);
					}
				});

		// Obtenemos el SpanContext
		Span span = Span.fromContext(extractedContext);
		SpanContext spanContext = span.getSpanContext();

		Map<String, List<String>> headers = exchange.getRequest().getHeaders();
		log.info("Headers: {}", headers);

		if (spanContext.isValid()) {
			String traceId = spanContext.getTraceId();
			// Aquí puedes loggear o guardar el traceId en el Reactor Context
			log.info("TraceId extraído: {}", traceId);

			// Propagarlo en el Reactor Context
			return chain.filter(exchange).contextWrite(ctx -> ctx.put("traceId", traceId));
		}

		return chain.filter(exchange);
	}

}
