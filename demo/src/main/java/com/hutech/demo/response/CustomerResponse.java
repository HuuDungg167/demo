package com.hutech.demo.response;

import com.hutech.demo.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerResponse {
    private Long id;

    private User user;

    private String address;

    private String preferences;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
