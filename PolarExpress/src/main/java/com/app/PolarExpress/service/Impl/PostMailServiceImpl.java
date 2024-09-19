package com.app.PolarExpress.service.Impl;

import com.app.PolarExpress.dto.PostMailStatusHistoryDto;
import com.app.PolarExpress.entity.PostMail;
import com.app.PolarExpress.entity.Tracking;
import com.app.PolarExpress.exception.ResourceNotFoundException;
import com.app.PolarExpress.repository.PostMailRepository;
import com.app.PolarExpress.repository.TrackingRepository;
import com.app.PolarExpress.service.PostMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostMailServiceImpl implements PostMailService {

    private final PostMailRepository postMailRepository;

    private final TrackingRepository trackingRepository;

    public PostMailStatusHistoryDto getPostMailStatusHistory(Integer id) {
        PostMail postMail = postMailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post mail not found"));

        List<Tracking> trackingList = trackingRepository.findByPostMailId(id);
        return new PostMailStatusHistoryDto(postMail.getStatus(), trackingList);
    }
}
