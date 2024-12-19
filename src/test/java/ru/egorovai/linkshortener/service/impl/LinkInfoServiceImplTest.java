package ru.egorovai.linkshortener.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.egorovai.linkshortener.dto.CreateLinkInfoRequest;
import ru.egorovai.linkshortener.LinkInfoResponse;
import ru.egorovai.linkshortener.repository.impl.LinkInfoRepositoryImpl;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LinkInfoServiceImplTest {

    private LinkInfoServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new LinkInfoServiceImpl(new LinkInfoRepositoryImpl());
    }

    @Test
    void testCreateLinkInfo() {
        CreateLinkInfoRequest request = new CreateLinkInfoRequest(
                "https://example.com",
                LocalDateTime.now().plusDays(7),
                "Test description",
                true
        );

        LinkInfoResponse response = service.createLinkInfo(request);

        assertNotNull(response, "Response should not be null");
        assertNotNull(response.getShortLink(), "Short link should not be null");
        assertEquals(6, response.getShortLink().length(), "Short link should have a length of 6");
        assertEquals(request.getLink(), response.getLink(), "Original link should match");
    }

    @Test
    void testGetByShortLink() {
        CreateLinkInfoRequest request = new CreateLinkInfoRequest(
                "https://example.com",
                LocalDateTime.now().plusDays(7),
                "Test description",
                true
        );

        LinkInfoResponse created = service.createLinkInfo(request);
        LinkInfoResponse retrieved = service.getByShortLink(created.getShortLink());

        assertNotNull(retrieved, "Retrieved response should not be null");
        assertEquals(created.getShortLink(), retrieved.getShortLink(), "Short link should match");
        assertEquals(created.getLink(), retrieved.getLink(), "Original link should match");
    }

    @Test
    void testFindByFilter() {
        CreateLinkInfoRequest request1 = new CreateLinkInfoRequest(
                "https://example1.com",
                LocalDateTime.now().plusDays(7),
                "Test 1",
                true
        );

        CreateLinkInfoRequest request2 = new CreateLinkInfoRequest(
                "https://example2.com",
                LocalDateTime.now().plusDays(5),
                "Test 2",
                true
        );

        service.createLinkInfo(request1);
        service.createLinkInfo(request2);

        var allLinks = service.findByFilter();

        assertEquals(2, allLinks.size(), "There should be 2 links in the storage");
    }
}