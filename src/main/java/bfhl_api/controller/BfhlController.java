package bfhl_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import bfhl_api.dto.RequestDTO;
import bfhl_api.dto.ResponseDTO;
import bfhl_api.service.BfhlService;

@RestController
public class BfhlController {

    @Autowired
    private BfhlService bfhlService;

    @PostMapping("/bfhl")
    public ResponseDTO process(@RequestBody RequestDTO request) {

        return bfhlService.processData(request);
    }
}