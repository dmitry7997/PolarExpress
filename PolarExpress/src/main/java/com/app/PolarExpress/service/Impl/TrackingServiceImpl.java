package com.app.PolarExpress.service.Impl;

import com.app.PolarExpress.dto.TrackingDto;
import com.app.PolarExpress.entity.PostMail;
import com.app.PolarExpress.entity.PostOffice;
import com.app.PolarExpress.entity.Tracking;
import com.app.PolarExpress.exception.ResourceNotFoundException;
import com.app.PolarExpress.mapper.TrackingMapper;
import com.app.PolarExpress.repository.PostMailRepository;
import com.app.PolarExpress.repository.PostOfficeRepository;
import com.app.PolarExpress.repository.TrackingRepository;
import com.app.PolarExpress.service.TrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TrackingServiceImpl implements TrackingService {

    private final TrackingRepository trackingRepository;

    private final TrackingMapper trackingMapper;

    private final PostMailRepository postMailRepository;

    private final PostOfficeRepository postOfficeRepository;

    @Override
    public TrackingDto createTracking(TrackingDto trackingDto) {
        Tracking tracking = trackingMapper.toTracking(trackingDto);

        Integer postMailId = trackingDto.getPostMailId();
        PostMail postMail = postMailRepository.findById(postMailId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Post mail does not exist with this id: " + postMailId));
        tracking.setPostMail(postMail);

        Integer postOfficeId = trackingDto.getPostOfficeId();
        PostOffice postOffice = postOfficeRepository.findById(postOfficeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Post office does not exist with this id: " + postOfficeId));
        tracking.setPostOffice(postOffice);

        Tracking savedTracking = trackingRepository.save(tracking);

        return trackingMapper.toTrackingDto(savedTracking);
    }
}
