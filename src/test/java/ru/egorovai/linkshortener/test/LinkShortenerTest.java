package ru.egorovai.linkshortener.test;

import org.junit.jupiter.api.Test;
import ru.egorovai.linkshortener.dto.CreateLinkInfoRequest;
import ru.egorovai.linkshortener.service.impl.LinkInfoServiceImpl;

import java.time.LocalDateTime;

public class LinkShortenerTest {

    @Test
    void testCreateLinkInfo() {
        LinkInfoServiceImpl service = new LinkInfoServiceImpl();

        CreateLinkInfoRequest request = new CreateLinkInfoRequest(
                "https://example.com/long-link",
                LocalDateTime.now().plusDays(7),
                "Test description",
                true
        );

        String shortLink = service.createLinkInfo(request);
        System.out.println("Generated short link: " + shortLink);
    }
}