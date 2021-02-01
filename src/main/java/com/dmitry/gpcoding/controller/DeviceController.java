package com.dmitry.gpcoding.controller;

import com.dmitry.gpcoding.domain.Device;
import com.dmitry.gpcoding.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@Validated
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
    public ResponseEntity<Object> addDevice( //@Valid
                                                @RequestBody Device device) {
        deviceService.createDevice(device);
        return new ResponseEntity<>("Device is created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/devices/{serialNumber}")
    public ResponseEntity<Object> updateDevice(@PathVariable("serialNumber") String serialNumber,
                                               // @Valid
                                               @RequestBody Device device) {
        deviceService.updateDevice(serialNumber, device);
        return new ResponseEntity<>("Device is updated successfully", HttpStatus.OK);
    }
}
