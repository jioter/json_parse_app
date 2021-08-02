package com.globallogic.json_parse.entity.inputJSON;

import lombok.Data;

import java.util.List;

@Data
public class InputJSON {
    public class NetworkPerformance{
        public java.lang.String configuration;
        public java.lang.String value;
    }

    public class SubBandInfo{
        public List<NetworkPerformance> networkPerformance;
        public List<java.lang.String> subBand;
    }

    public class BandInfo{
        public java.lang.String bandName;
        public List<SubBandInfo> subBandInfo;
    }

    public class BandDetail{
        public java.lang.String categoryName;
        public List<BandInfo> bandInfo;
    }

    public class Root{
        public java.lang.String tac;
        public java.lang.String manufacturer;
        public java.lang.String modelName;
        public java.lang.String marketingName;
        public java.lang.String brandName;
        public java.lang.String allocationDate;
        public java.lang.String organisationId;
        public java.lang.String deviceType;
        public java.lang.String bluetooth;
        public java.lang.String nfc;
        public java.lang.String wlan;
        public java.lang.String removableUICC;
        public java.lang.String removableEUICC;
        public java.lang.String nonremovableUICC;
        public java.lang.String nonremovableEUICC;
        public java.lang.String simSlot;
        public java.lang.String imeiQuantity;
        public java.lang.String operatingSystem;
        public java.lang.String oem;
        public List<BandDetail> bandDetails;
    }
}
