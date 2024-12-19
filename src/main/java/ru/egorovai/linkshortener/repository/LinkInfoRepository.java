package ru.egorovai.linkshortener.repository;

import ru.egorovai.linkshortener.model.LinkInfo;

import java.util.List;

public interface LinkInfoRepository {

    LinkInfo findByShortLink(String shortLink);

    LinkInfo save(LinkInfo linkInfo);

    List<LinkInfo> findAll();
}