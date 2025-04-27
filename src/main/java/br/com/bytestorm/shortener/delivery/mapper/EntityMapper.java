package br.com.bytestorm.shortener.delivery.mapper;

import br.com.bytestorm.shortener.domain.entities.Shortener;
import br.com.bytestorm.shortener.infra.persistence.ShortenerEntity;

public class EntityMapper {

    private static EntityMapper instance;

    private EntityMapper() {}

    public static synchronized EntityMapper getInstance() {
        if (instance == null) {
            instance = new EntityMapper();
        }
        return instance;
    }

    public Shortener toShortenerEntity(ShortenerEntity shortener) {
        return new Shortener(
                shortener.getId(),
                shortener.getOriginalUrl(),
                shortener.getShortUrl(),
                shortener.getActive()
        );
    }

    public ShortenerEntity toShortenerDomain(Shortener shortener) {
        return new ShortenerEntity(
                shortener.getId(),
                shortener.getOriginalUrl(),
                shortener.getShortUrl(),
                shortener.getActive()
        );
    }

}
