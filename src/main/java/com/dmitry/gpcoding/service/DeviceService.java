package com.dmitry.gpcoding.service;

import com.dmitry.gpcoding.domain.Device;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DeviceService {
    private static Map<String, Device> deviceRepo = new HashMap<>();

    // hardcoded repo for the exercise. Normally, this would be a DB repo
    static {
        Device device1 = new Device("12-1222", "machineCode1", "device1");
        Device device2 = new Device("3455670-22222", "machineCode2", "device2");
        Device device3 = new Device("1-00022221", "machineCode3", "device3");

        deviceRepo.put(device1.getSerialNumber(), device1);
        deviceRepo.put(device2.getSerialNumber(), device2);
        deviceRepo.put(device3.getSerialNumber(), device3);
    }

    public List<Device> getCustomers() {
        return deviceRepo.values().stream().collect(Collectors.toList());
    }

    public void createDevice(Device device) {
        deviceRepo.put(device.getSerialNumber(), device);
    }

    public void updateDevice(String serialNumber, Device device) {
        deviceRepo.remove(serialNumber);
        deviceRepo.put(device.getSerialNumber(), device);
    }

    public Device findBySerial(String serialNumber) {
        return deviceRepo.get(serialNumber);
    }
}
