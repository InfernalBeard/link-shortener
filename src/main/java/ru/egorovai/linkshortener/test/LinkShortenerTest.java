package ru.egorovai.linkshortener.test;

import ru.egorovai.linkshortener.dto.CreateLinkInfoRequest;
import ru.egorovai.linkshortener.service.impl.LinkInfoServiceImpl;

import java.time.LocalDateTime;

public class LinkShortenerTest {
    public static void main(String[] args) {
        LinkInfoServiceImpl service = new LinkInfoServiceImpl();

        // Создаем объект DTO
        CreateLinkInfoRequest request = new CreateLinkInfoRequest(
                "https://example.com/long-link",
                LocalDateTime.now().plusDays(7),
                "Test description",
                true
        );

        String shortLink = service.generateShortLink(request);
        System.out.println("Generated short link: " + shortLink);
    }
}