package com.app.PolarExpress.controller;

import com.app.PolarExpress.dto.PostMailStatusHistoryDto;
import com.app.PolarExpress.service.Impl.PostMailServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostMailController {

    private final PostMailServiceImpl postMailService;

    @Tag(name = "Статус и история", description = "Просмотр статуса и полной истории движения почтового отправления")
    @GetMapping("/status-history/{id}")
    public ResponseEntity<PostMailStatusHistoryDto> getPostMailStatusHistory(@PathVariable Integer id) {
    PostMailStatusHistoryDto statusHistory = postMailService.getPostMailStatusHistory(id);
    return ResponseEntity.ok(statusHistory);
    }
}
