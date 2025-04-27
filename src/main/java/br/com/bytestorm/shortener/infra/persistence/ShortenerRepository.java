package br.com.bytestorm.shortener.infra.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortenerRepository extends MongoRepository<ShortenerEntity, String> {
    Optional<ShortenerEntity> findByShortUrl(String shortUrl);
}
