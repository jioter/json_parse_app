package com.globallogic.json_parse.service;
import com.globallogic.json_parse.entity.ResponseVO;
import com.globallogic.json_parse.entity.inputJSON.Root;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;


import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class JSONProcessingService {
    private final ObjectMapper objectMapper;

    final String TABLE_HEAD = "tac | Manufacturer | Model Name | Allocation Date | Device Type ";

    @SneakyThrows
    public List<ResponseVO> JSONtoListOfResponseVO(String inputJSON) {
        Root[] json = objectMapper.readValue(inputJSON, Root[].class);

        List<ResponseVO> responseVOList = Arrays.stream(json)
                .map(this::convertToVO)
                .collect(Collectors.toList());

        return responseVOList;
    }

    @SneakyThrows
    public byte[] writeToTxt(List<ResponseVO> data) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] byteArrayOfResponseVO = new byte[0];

        outputStream.write(TABLE_HEAD.getBytes());
        outputStream.write("\n".getBytes());

        for (ResponseVO el : data) {
            outputStream.write(convertResponseVOtoByteArray(el));

        byteArrayOfResponseVO = outputStream.toByteArray();

        }
        return byteArrayOfResponseVO;
    }

    private ResponseVO convertToVO(Root root) {
        ResponseVO responseVO = new ResponseVO();

        responseVO.setTac(root.getTac());
        responseVO.setManufacturer(root.getManufacturer());
        responseVO.setModelName(root.getModelName());
        responseVO.setAllocationDate(root.getAllocationDate());
        responseVO.setDeviceType(root.getDeviceType());

        return responseVO;
    }

    @SneakyThrows
    private byte[] convertResponseVOtoByteArray(ResponseVO responseVO){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        outputStream.write(responseVO.getTac().getBytes());
        outputStream.write(" | ".getBytes());
        outputStream.write(responseVO.getManufacturer().getBytes());
        outputStream.write(" | ".getBytes());
        outputStream.write(responseVO.getModelName().getBytes());
        outputStream.write(" | ".getBytes());
        outputStream.write(responseVO.getAllocationDate().getBytes());
        outputStream.write(" | ".getBytes());
        outputStream.write(responseVO.getDeviceType().getBytes());
        outputStream.write("\n".getBytes());

        return outputStream.toByteArray();
    }
}