package br.com.bytestorm.shortener.domain.gateways;

import br.com.bytestorm.shortener.application.gateways.ShortenerGateway;
import br.com.bytestorm.shortener.delivery.dto.MessageDTO;
import br.com.bytestorm.shortener.delivery.mapper.EntityMapper;
import br.com.bytestorm.shortener.domain.entities.Shortener;
import br.com.bytestorm.shortener.domain.exceptions.FieldCannotEmptyException;
import br.com.bytestorm.shortener.domain.exceptions.NotFoundException;
import br.com.bytestorm.shortener.infra.persistence.ShortenerEntity;
import br.com.bytestorm.shortener.infra.persistence.ShortenerRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ShortenerRepositoryGateway implements ShortenerGateway {

    private final ShortenerRepository shortenerRepository;

    public ShortenerRepositoryGateway(ShortenerRepository shortenerRepository) {
        this.shortenerRepository = shortenerRepository;
    }

    @Override
    public MessageDTO createShortener(Shortener shortener) {

        if (shortener.getOriginalUrl().isEmpty()) throw new FieldCannotEmptyException("Por favor, insira ao menos a url atual");

        if (shortener.getShortUrl().isEmpty()) throw new FieldCannotEmptyException("Por favor, insira ao menos a nova");

        shortener.setActive(true);

        shortenerRepository.save(
                EntityMapper.getInstance().toShortenerDomain(shortener)
        );

        return new MessageDTO("Url encurtada com sucesso.", 201);
    }

    @Override
    public String redirectToOriginalUrl(String shortener) {
        Optional<ShortenerEntity> shortenerOpt = shortenerRepository.findByShortUrl(shortener);
        return shortenerOpt.map(ShortenerEntity::getOriginalUrl).orElseThrow(
                () -> new NotFoundException("https://i.pinimg.com/originals/9b/e2/0e/9be20e6d12d76270ebb6559f0764cce4.gif")
        );
    }
}
