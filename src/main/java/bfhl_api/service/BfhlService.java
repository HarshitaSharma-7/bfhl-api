package bfhl_api.service;

import bfhl_api.dto.RequestDTO;
import bfhl_api.dto.ResponseDTO;

public interface BfhlService {

    ResponseDTO processData(RequestDTO request);
}