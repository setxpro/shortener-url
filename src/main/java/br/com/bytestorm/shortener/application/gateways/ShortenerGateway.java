package br.com.bytestorm.shortener.application.gateways;

import br.com.bytestorm.shortener.delivery.dto.MessageDTO;
import br.com.bytestorm.shortener.domain.entities.Shortener;

public interface ShortenerGateway {
    MessageDTO createShortener(Shortener shortener);
    String redirectToOriginalUrl(String shortener);
}
