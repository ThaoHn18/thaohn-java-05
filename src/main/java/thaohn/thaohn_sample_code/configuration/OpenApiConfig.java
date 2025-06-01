package thaohn.thaohn_sample_code.configuration;

import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.IntegerSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("!prod")  // build tat ca moi truong loai tru product
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI(@Value("${open.api.title}") String title,
                           @Value("${open.api.version}") String version,
                           @Value("${open.api.description}") String description,
                           @Value("${open.api.serverUrl}") String serverUrl,
                           @Value("${open.api.serverName}") String serverName
                           ) {
        return new OpenAPI().info(new Info().title(title).version(version)
                .description(description)
                .license(new License().name("License Thao")))
                .servers(List.of(new Server().url(serverUrl).description(serverName)));
//                .components(new Components()
//                        .addSecuritySchemes("bearerAuth",
//                                new SecurityScheme()
//                                        .type(SecurityScheme.Type.HTTP) // ← THIS IS CORRECT USAGE
//                                        .scheme("bearer")
//                                        .bearerFormat("JWT")
//                        )
//                )
//                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    }

    @Bean
    public GroupedOpenApi groupedOpenApi () {
        return GroupedOpenApi.builder()
                .group("thaohn-sample-code1")
                .packagesToScan("thaohn.thaohn_sample_code.controller")
                .build();
    }
}
