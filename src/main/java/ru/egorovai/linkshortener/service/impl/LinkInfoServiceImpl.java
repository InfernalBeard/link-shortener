package ru.egorovai.linkshortener.service.impl;

import net.datafaker.Faker;
import org.springframework.stereotype.Service;
import ru.egorovai.linkshortener.Constants;
import ru.egorovai.linkshortener.dto.CreateLinkInfoRequest;
import ru.egorovai.linkshortener.LinkInfoResponse;
import ru.egorovai.linkshortener.exception.NotFoundException;
import ru.egorovai.linkshortener.model.LinkInfo;
import ru.egorovai.linkshortener.repository.LinkInfoRepository;
import ru.egorovai.linkshortener.service.LinkInfoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LinkInfoServiceImpl implements LinkInfoService {

    private final LinkInfoRepository repository;
    private final Faker faker = new Faker();

    public LinkInfoServiceImpl(LinkInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public LinkInfoResponse createLinkInfo(CreateLinkInfoRequest request) {
        String shortLink;
        do {
            shortLink = faker.regexify("[a-zA-Z0-9]{" + Constants.SHORT_LINK_LENGTH + "}");
        } while (repository.findByShortLink(shortLink) != null);

        LinkInfo linkInfo = new LinkInfo();
        linkInfo.setLink(request.getLink());
        linkInfo.setEndTime(request.getEndTime());
        linkInfo.setDescription(request.getDescription());
        linkInfo.setActive(request.getActive());
        linkInfo.setShortLink(shortLink);
        linkInfo.setOpeningCount(0L);

        repository.save(linkInfo);

        return toResponse(linkInfo);
    }

    @Override
    public LinkInfoResponse getByShortLink(String shortLink) {
        LinkInfo linkInfo = repository.findByShortLink(shortLink);
        if (linkInfo == null) {
            throw new NotFoundException("Short link not found: " + shortLink);
        }
        return toResponse(linkInfo);
    }

    @Override
    public List<LinkInfoResponse> findByFilter() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private LinkInfoResponse toResponse(LinkInfo linkInfo) {
        return new LinkInfoResponse(
                linkInfo.getId(),
                linkInfo.getLink(),
                linkInfo.getEndTime(),
                linkInfo.getDescription(),
                linkInfo.getActive(),
                linkInfo.getShortLink(),
                linkInfo.getOpeningCount()
        );
    }
}