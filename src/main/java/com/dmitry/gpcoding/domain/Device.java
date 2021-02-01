package com.dmitry.gpcoding.domain;


import org.springframework.lang.NonNull;

// Would normally be annotated as a JPA entity
public class Device {
    private String serialNumber;
    private String machineCode;
    private String name;

    public Device(String serialNumber, String machineCode, String name) {
        this.serialNumber = serialNumber;
        this.machineCode = machineCode;
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    @NonNull
    public String getMachineCode() {
        return machineCode;
    }

    public String getName() {
        return name;
    }
}
