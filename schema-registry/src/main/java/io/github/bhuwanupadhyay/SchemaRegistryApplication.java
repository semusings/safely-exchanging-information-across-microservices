package io.github.bhuwanupadhyay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.schema.registry.EnableSchemaRegistryServer;

@SpringBootApplication
@EnableSchemaRegistryServer
public class SchemaRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchemaRegistryApplication.class, args);
	}
}
