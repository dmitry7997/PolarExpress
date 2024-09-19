package com.app.PolarExpress.mapper;

import com.app.PolarExpress.dto.TrackingDto;
import com.app.PolarExpress.entity.Tracking;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-19T20:07:32+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class TrackingMapperImpl implements TrackingMapper {

    @Override
    public TrackingDto toTrackingDto(Tracking tracking) {
        if ( tracking == null ) {
            return null;
        }

        TrackingDto trackingDto = new TrackingDto();

        trackingDto.setMoving( tracking.getMoving() );
        trackingDto.setCreationDate( tracking.getCreationDate() );

        return trackingDto;
    }

    @Override
    public Tracking toTracking(TrackingDto trackingDto) {
        if ( trackingDto == null ) {
            return null;
        }

        Tracking tracking = new Tracking();

        tracking.setMoving( trackingDto.getMoving() );
        tracking.setCreationDate( trackingDto.getCreationDate() );

        return tracking;
    }
}
