package com.miyani.sample.spring.boot.jpa.controller;

import com.miyani.sample.spring.boot.jpa.dto.FileInfoDTO;
import com.miyani.sample.spring.boot.jpa.entity.FileInfo;
import com.miyani.sample.spring.boot.jpa.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;

@Controller
public class FileController
{
    private Logger logger = LoggerFactory.getLogger(this.getClass().getCanonicalName());

    @Autowired
    private FileService fileService;

    @ResponseBody
    @RequestMapping(value="jpaFileUpload.do")
    public String jpaFileUpload(MultipartHttpServletRequest request)
    {
        logger.debug("enter");

        request.getFileMap().entrySet().stream().forEach( it -> {
            logger.debug("key={}, value={}", it.getKey(), it.getValue() );

            String fileName = it.getKey();
            MultipartFile multipartFile = it.getValue();

            FileInfoDTO fileInfoDTO = new FileInfoDTO();
            fileInfoDTO.setFileName( multipartFile.getName() );
            fileInfoDTO.setSize( multipartFile.getSize() );
            fileInfoDTO.setContentType( multipartFile.getContentType() );
            fileInfoDTO.setOriginalFileName(  multipartFile.getOriginalFilename() );
            try {
                fileInfoDTO.setContents( multipartFile.getBytes() );
            }
            catch (IOException e) {
                logger.error("file read error", e);
            }

            FileInfo fileInfo = fileService.inputFileInfo(fileInfoDTO);
            logger.debug("file_id ={}", fileInfo.getId());
        });

        return "success";
    }

    @ResponseBody
    @PostMapping("jdbcFileUpload.do")
    public String jdbcFileUpload(@RequestParam("jdbcfile") MultipartFile multipartFile) throws IOException {
        logger.debug("enter");

        FileInfoDTO fileInfoDTO = new FileInfoDTO();
        fileInfoDTO.setFileName( multipartFile.getName() );
        fileInfoDTO.setSize( multipartFile.getSize() );
        fileInfoDTO.setContentType( multipartFile.getContentType() );
        fileInfoDTO.setOriginalFileName(  multipartFile.getOriginalFilename() );
        fileInfoDTO.setContents( multipartFile.getBytes() );

        int insertCnt = this.fileService.inputJbbcFileInfo(fileInfoDTO);

        return "success " + insertCnt;
    }
}
