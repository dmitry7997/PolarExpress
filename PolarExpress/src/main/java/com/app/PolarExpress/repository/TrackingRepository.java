package com.app.PolarExpress.repository;

import com.app.PolarExpress.entity.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackingRepository extends JpaRepository<Tracking, Integer> {
    List<Tracking> findByPostMailId(Integer postMailId);
}
