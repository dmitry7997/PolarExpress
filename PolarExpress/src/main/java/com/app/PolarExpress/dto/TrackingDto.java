package com.app.PolarExpress.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrackingDto {
    private Integer postOfficeId;
    private Integer postMailId;

    @Schema(description = "Установлено ограничение на добавление значений",  example = "Регистрация, Прибытие, Убытие, Получение")
    private String moving;
    private LocalDateTime creationDate;
}
