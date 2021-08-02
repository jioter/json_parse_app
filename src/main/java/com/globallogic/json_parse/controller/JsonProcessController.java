package com.globallogic.json_parse.controller;

import com.globallogic.json_parse.entity.ResponseVO;
import com.globallogic.json_parse.service.JSONProcessingService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/json_converter")
@RequiredArgsConstructor
public class JsonProcessController {
    private final JSONProcessingService jsonProcessingService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<List<ResponseVO>> processJSON(@RequestBody String inputJson) {
        return ResponseEntity.ok(jsonProcessingService.JSONtoListOfResponseVO(inputJson));
    }

    @SneakyThrows
    @ResponseBody
    @RequestMapping(value = "/to_txt", method = RequestMethod.POST)
    public ResponseEntity<byte[]> processJSONtoTXT(@RequestBody String inputJson) {

        byte[] output = jsonProcessingService.writeToTxt(
                        jsonProcessingService.JSONtoListOfResponseVO(inputJson));

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.TEXT_PLAIN);
        responseHeaders.setContentLength(output.length);

        return new ResponseEntity<>(output, responseHeaders, HttpStatus.OK);
    }
}

