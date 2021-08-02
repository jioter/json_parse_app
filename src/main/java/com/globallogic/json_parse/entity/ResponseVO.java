package com.globallogic.json_parse.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseVO {
    private String tac;
    private String manufacturer;
    private String modelName;
    private String allocationDate;
    private String deviceType;
}
