package br.com.bytestorm.shortener.delivery.controllers;

import br.com.bytestorm.shortener.application.usecases.CreateShortenerUseCase;
import br.com.bytestorm.shortener.application.usecases.RedirectToOriginalUrlUseCase;
import br.com.bytestorm.shortener.delivery.dto.MessageDTO;
import br.com.bytestorm.shortener.domain.entities.Shortener;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog")
public class ShortenerController {

    private final CreateShortenerUseCase createShortenerUseCase;
    private final RedirectToOriginalUrlUseCase redirectToOriginalUrlUseCase;

    public ShortenerController(CreateShortenerUseCase createShortenerUseCase, RedirectToOriginalUrlUseCase redirectToOriginalUrlUseCase) {
        this.createShortenerUseCase = createShortenerUseCase;
        this.redirectToOriginalUrlUseCase = redirectToOriginalUrlUseCase;
    }

    @PostMapping
    public ResponseEntity<MessageDTO> createShortener(@RequestBody Shortener shortener) {
        return new ResponseEntity<>(createShortenerUseCase.execute(shortener), HttpStatus.CREATED);
    }

    @GetMapping("/{shortener}")
    public ResponseEntity<Void> redirectTo(@PathVariable("shortener") String shortener) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Location", redirectToOriginalUrlUseCase.execute(shortener));
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }
}
