package com.app.PolarExpress.mapper;

import com.app.PolarExpress.dto.TrackingDto;
import com.app.PolarExpress.entity.Tracking;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TrackingMapper {
    TrackingDto toTrackingDto(Tracking tracking);

    Tracking toTracking(TrackingDto trackingDto);
}
