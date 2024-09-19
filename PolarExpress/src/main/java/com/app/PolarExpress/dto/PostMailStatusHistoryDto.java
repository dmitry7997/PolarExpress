package com.app.PolarExpress.dto;

import com.app.PolarExpress.entity.PostMail;
import com.app.PolarExpress.entity.Tracking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostMailStatusHistoryDto {
    private String status;
    private List<Tracking> trackingList;
}
