package com.globallogic.json_parse.entity.inputJSON;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Root {
    private String tac;
    private String manufacturer;
    private String modelName;
    private String marketingName;
    private String brandName;
    private String allocationDate;
    private String organisationId;
    private String deviceType;
    private String bluetooth;
    private String nfc;
    private String wlan;
    private String removableUICC;
    private String removableEUICC;
    private String nonremovableUICC;
    private String nonremovableEUICC;
    private String simSlot;
    private String imeiQuantity;
    private String operatingSystem;
    private String oem;
    private List<BandDetail> bandDetails;
}
