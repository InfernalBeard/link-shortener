package ru.egorovai.linkshortener.service;

import ru.egorovai.linkshortener.LinkInfoResponse;
import ru.egorovai.linkshortener.dto.CreateLinkInfoRequest;

import java.util.List;

public interface LinkInfoService {

    LinkInfoResponse createLinkInfo(CreateLinkInfoRequest request);
    LinkInfoResponse getByShortLink(String shortLink);
    List<LinkInfoResponse> findByFilter();
}