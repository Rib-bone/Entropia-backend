package risto.turtiainen.entropia_backend.conf;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import org.slf4j.Logger;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Component
@WebFilter(filterName = "RequestCachingFilter", urlPatterns = "/*")
public class RequestLoggingFilter extends OncePerRequestFilter {

    private static final Logger httpLogger =
            LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String method = request.getMethod();
        String uri = request.getRequestURI();
        String query = request.getQueryString();

        httpLogger.info("Incoming: {} {}{}",
                method,
                uri,
                query != null ? "?" + query : "");

        LocalTime requestTime = LocalTime.now();
        filterChain.doFilter(request, response);

        int status = response.getStatus();
        httpLogger.info("Outgoing: HTTP {}, took {}ms", status, Duration.between(requestTime, LocalTime.now()).toMillis());
    }
}
