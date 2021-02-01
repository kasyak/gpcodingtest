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

    //@NotEmpty(message = "The serial number does not match our records.")
    public String getSerialNumber() {
        return serialNumber;
    }

    //@NotEmpty(message = "The machine code does not match our records.")
    public String getMachineCode() {
        return machineCode;
    }

    public String getName() {
        return name;
    }
}
