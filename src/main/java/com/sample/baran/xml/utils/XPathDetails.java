package com.sample.baran.xml.utils;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class XPathDetails {
    private String newXPath;
    private String tagOrAttributeName;
    private String value;
    private boolean isTag;
}
