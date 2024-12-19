package ru.egorovai.linkshortener.repository.impl;

import ru.egorovai.linkshortener.model.LinkInfo;
import ru.egorovai.linkshortener.repository.LinkInfoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class LinkInfoRepositoryImpl implements LinkInfoRepository {

    private final Map<String, LinkInfo> storage = new ConcurrentHashMap<>();

    @Override
    public LinkInfo findByShortLink(String shortLink) {
        return storage.get(shortLink);
    }

    @Override
    public LinkInfo save(LinkInfo linkInfo) {
        linkInfo.setId(UUID.randomUUID()); // Генерация ID
        storage.put(linkInfo.getShortLink(), linkInfo);
        return linkInfo;
    }

    @Override
    public List<LinkInfo> findAll() {
        return new ArrayList<>(storage.values());
    }
}
