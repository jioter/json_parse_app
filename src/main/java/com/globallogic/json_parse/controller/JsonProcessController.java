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
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;


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
    public ResponseEntity<byte[]> processJSONtoTXT(
            @RequestParam("inputFile") MultipartFile inputFile) {

        List<String> result = new BufferedReader(new InputStreamReader(inputFile.getInputStream()))
                .lines().collect(Collectors.toList());

        byte[] output = jsonProcessingService.writeToTxt(
                jsonProcessingService.JSONtoListOfResponseVO(result.toString()));

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.TEXT_PLAIN);
        responseHeaders.setContentLength(output.length);

        return new ResponseEntity<>(output, responseHeaders, HttpStatus.OK);
    }
}

