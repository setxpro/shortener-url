package br.com.bytestorm.shortener.application.usecases;

import br.com.bytestorm.shortener.delivery.dto.MessageDTO;
import br.com.bytestorm.shortener.domain.entities.Shortener;

public interface CreateShortenerUseCase {
    MessageDTO execute(Shortener shortener);
}
