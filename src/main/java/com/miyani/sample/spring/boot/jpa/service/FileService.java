package com.miyani.sample.spring.boot.jpa.service;

import com.miyani.sample.spring.boot.jpa.dto.FileInfoDTO;
import com.miyani.sample.spring.boot.jpa.entity.FileInfo;
import com.miyani.sample.spring.boot.jpa.repository.FileJdbcRepository;
import com.miyani.sample.spring.boot.jpa.repository.FileJpaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FileService
{
    private final FileJpaRepository fileJpaRepository;
    private final FileJdbcRepository fileJdbcRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FileService(FileJpaRepository fileJpaRepository, FileJdbcRepository fileJdbcRepository, ModelMapper modelMapper) {
        this.fileJpaRepository = fileJpaRepository;
        this.fileJdbcRepository = fileJdbcRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<FileInfo> getFile(UUID id) {
        return fileJpaRepository.findById(id);
    }

    public FileInfo inputFileInfo(FileInfoDTO fileInfoDTO)
    {
        FileInfo fileInfo = modelMapper.map(fileInfoDTO, FileInfo.class);
        return fileJpaRepository.save(fileInfo);
    }

    public int inputJbbcFileInfo(FileInfoDTO fileInfoDTO)
    {
        return fileJdbcRepository.save(fileInfoDTO);
    }
}
