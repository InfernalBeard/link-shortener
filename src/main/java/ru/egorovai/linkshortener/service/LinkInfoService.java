package ru.egorovai.linkshortener.service;

import ru.egorovai.linkshortener.dto.CreateLinkInfoRequest;

public interface LinkInfoService {
    String generateShortLink(CreateLinkInfoRequest request);
}