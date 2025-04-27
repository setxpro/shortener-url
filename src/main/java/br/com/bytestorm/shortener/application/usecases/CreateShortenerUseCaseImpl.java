package br.com.bytestorm.shortener.application.usecases;

import br.com.bytestorm.shortener.application.gateways.ShortenerGateway;
import br.com.bytestorm.shortener.delivery.dto.MessageDTO;
import br.com.bytestorm.shortener.domain.entities.Shortener;

public class CreateShortenerUseCaseImpl implements CreateShortenerUseCase {

    private final ShortenerGateway shortenerGateway;

    public CreateShortenerUseCaseImpl(ShortenerGateway shortenerGateway) {
        this.shortenerGateway = shortenerGateway;
    }

    @Override
    public MessageDTO execute(Shortener shortener) {
        return shortenerGateway.createShortener(shortener);
    }
}
