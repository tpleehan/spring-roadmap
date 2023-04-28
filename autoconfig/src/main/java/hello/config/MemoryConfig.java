package hello.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import memory.MemoryController;
import memory.MemoryFinder;

@Configuration
// @Conditional(MemoryCondition.class)
@ConditionalOnProperty(name = "memory", havingValue = "on") // 추가
public class MemoryConfig {

	@Bean
	public MemoryController memoryController() {
		return new MemoryController(memoryFinder());
	}

	@Bean
	public MemoryFinder memoryFinder() {
		return new MemoryFinder();
	}

}
