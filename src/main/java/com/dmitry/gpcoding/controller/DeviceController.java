package com.dmitry.gpcoding.controller;

import com.dmitry.gpcoding.domain.Device;
import com.dmitry.gpcoding.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    /**
     * Get all the devices available
     * @return list of devices
     */
    @GetMapping("/devices")
    public ResponseEntity <List<Device>> getDevices() {
        List <Device> devices = deviceService.getCustomers();
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @GetMapping("/devices/{serialNumber}")
    public ResponseEntity <Device> findDevice(@PathVariable("serialNumber") String serialNumber) {
        Device device = deviceService.findBySerial(serialNumber);
        return new ResponseEntity<>(device, HttpStatus.OK);
    }

    @PostMapping("/devices")
    public ResponseEntity<Object> addDevice(@RequestBody Device device) {
        deviceService.createDevice(device);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/devices/{serialNumber}")
    public ResponseEntity<Object> updateProduct(@PathVariable("serialNumber") String serialNumber, @RequestBody Device device) {
        deviceService.updateDevice(serialNumber, device);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }
}
