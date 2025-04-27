package br.com.bytestorm.shortener.infra.configs;

import br.com.bytestorm.shortener.application.gateways.ShortenerGateway;
import br.com.bytestorm.shortener.application.usecases.CreateShortenerUseCase;
import br.com.bytestorm.shortener.application.usecases.CreateShortenerUseCaseImpl;
import br.com.bytestorm.shortener.application.usecases.RedirectToOriginalUrlUseCase;
import br.com.bytestorm.shortener.application.usecases.RedirectToOriginalUrlUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    CreateShortenerUseCase createShortenerUseCase(ShortenerGateway shortenerGateway) {
        return new CreateShortenerUseCaseImpl(shortenerGateway);
    };

    @Bean
    RedirectToOriginalUrlUseCase redirectToOriginalUrlUseCase(ShortenerGateway shortenerGateway) {
        return new RedirectToOriginalUrlUseCaseImpl(shortenerGateway);
    };
}
