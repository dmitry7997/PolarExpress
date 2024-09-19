package com.app.PolarExpress.service;

import com.app.PolarExpress.dto.PostMailStatusHistoryDto;

public interface PostMailService {
    PostMailStatusHistoryDto getPostMailStatusHistory(Integer id);
}
