package ru.egorovai.linkshortener.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateLinkInfoRequest {
    private String link;
    private LocalDateTime endTime;
    private String description;
    private Boolean active;
}