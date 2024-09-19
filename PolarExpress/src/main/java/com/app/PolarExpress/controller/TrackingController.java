package com.app.PolarExpress.controller;

import com.app.PolarExpress.dto.TrackingDto;
import com.app.PolarExpress.service.TrackingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TrackingController {

    private final TrackingService trackingService;

    @Tag(name = "Передвижение отправления", description = "Возможность реализации регистрации, прибытия, убытия, получения почтового отправления")
    @PostMapping("/tracking")
    public ResponseEntity<TrackingDto> createTracking(@RequestBody TrackingDto trackingDto) {
        TrackingDto savedTracking = trackingService.createTracking(trackingDto);
        return new ResponseEntity<>(savedTracking, HttpStatus.CREATED);
    }
}
