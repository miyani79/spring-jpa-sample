package com.miyani.sample.spring.boot.jpa.repository;

import com.miyani.sample.spring.boot.jpa.dto.FileInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class FileJdbcRepository
{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FileJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(FileInfoDTO fileInfoDTO) {
        return jdbcTemplate.update(
                "insert\n" +
                "into\n" +
                "tb_file_info\n" +
                "(contents, file_name, org_file_name, file_id)\n" +
                "values\n" +
                "(?, ?, ?, ?)\n",
                fileInfoDTO.getContents(), fileInfoDTO.getFileName(), fileInfoDTO.getOriginalFileName(), UUID.randomUUID()) ;
    }
}
