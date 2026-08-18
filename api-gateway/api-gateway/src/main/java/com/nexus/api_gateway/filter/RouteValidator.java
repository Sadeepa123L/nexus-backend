package com.nexus.api_gateway.filter;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouteValidator {

    public static final List<String> openApiEndpoints = List.of(
            "/auth/register",
            "/auth/login",
            "/eureka"
    );

    public boolean isSecured(HttpServletRequest request) {
        return openApiEndpoints.stream()
                .noneMatch(uri -> request.getRequestURI().contains(uri));
    }
}
