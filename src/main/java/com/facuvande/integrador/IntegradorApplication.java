package com.facuvande.integrador;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IntegradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegradorApplication.class, args);
	}

        @Bean
        public OpenAPI customOpenAPI(){
            return new OpenAPI().info(new Info()
                    .title("Documentacion proyecto final API con SpringBoot")
                    .version("0.1.1")
                    .description("Documentacion del proyecto final de Desarrollo de API con Springboot de todocode")
            );
        }
}
