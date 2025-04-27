package br.com.bytestorm.shortener.application.usecases;

public interface RedirectToOriginalUrlUseCase {
    String execute(String shortener);
}
