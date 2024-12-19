package ru.egorovai.linkshortener.service.impl;

import net.datafaker.Faker;
import org.springframework.stereotype.Service;
import ru.egorovai.linkshortener.dto.CreateLinkInfoRequest;
import ru.egorovai.linkshortener.service.LinkInfoService;

import java.util.HashMap;
import java.util.Map;

@Service
public class LinkInfoServiceImpl implements LinkInfoService {

    private final Map<String, CreateLinkInfoRequest> linkStorage = new HashMap<>();
    private final Faker faker = new Faker();

    @Override
    public String createLinkInfo(CreateLinkInfoRequest request) {
        String shortLink = faker.regexify("[a-zA-Z0-9]{6}");
        linkStorage.put(shortLink, request);
        return shortLink;
    }
}