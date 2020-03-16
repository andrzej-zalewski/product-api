package pl.anzasolutions.product.api.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
public class TimeIntervalDto {

    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime from = LocalDateTime.MIN;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime to = LocalDateTime.MAX;
}
