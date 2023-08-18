package com.api.config;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
@Configuration
public class GatewayRoutingConfig {
	@Bean
	public RouteLocator configRoute(RouteLocatorBuilder builder) {
//=================	 	static Routing ====================================================
//		return builder.routes()
//			.route("empId",r->r.path("/api/v1/**").uri("http://localhost:8085"))//give here port number of client service and request mapping also url
//			.build();
//		Dynamic Routing
		return builder.routes()
				.route("empId",r->r.path("/api/v1/**").uri("lb://employeerest-service"))//give here port number of client service and request mapping also url
				.build();
	}
}

//8085 -> RestFulpracticeown
//8761 -> Eureka Default port
//8084 -> Api Gate way port
//we can also use static routing