package com.elsevier.submissions.provider.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {
    
    private final String message;
}
