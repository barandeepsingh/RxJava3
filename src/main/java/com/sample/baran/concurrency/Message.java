package com.sample.baran.concurrency;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Message {
    private int messageId;
    private String messageContent;

}
