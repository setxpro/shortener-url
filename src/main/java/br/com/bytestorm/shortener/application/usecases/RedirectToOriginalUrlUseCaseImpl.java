package br.com.bytestorm.shortener.application.usecases;

import br.com.bytestorm.shortener.application.gateways.ShortenerGateway;

public class RedirectToOriginalUrlUseCaseImpl implements RedirectToOriginalUrlUseCase {

    private final ShortenerGateway shortenerGateway;

    public RedirectToOriginalUrlUseCaseImpl(ShortenerGateway shortenerGateway) {
        this.shortenerGateway = shortenerGateway;
    }

    @Override
    public String execute(String shortener) {
        return shortenerGateway.redirectToOriginalUrl(shortener);
    }
}
