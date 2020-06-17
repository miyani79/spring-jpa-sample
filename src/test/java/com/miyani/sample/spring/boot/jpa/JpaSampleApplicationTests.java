package com.miyani.sample.spring.boot.jpa;

import com.miyani.sample.spring.boot.jpa.dto.FileInfoDTO;
import com.miyani.sample.spring.boot.jpa.entity.FileInfo;
import com.miyani.sample.spring.boot.jpa.repository.FileJdbcRepository;
import com.miyani.sample.spring.boot.jpa.repository.FileJpaRepository;
import com.miyani.sample.spring.boot.jpa.service.FileService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaSampleApplicationTests {

	@Autowired
	FileService fileService;

	@Autowired
	FileJpaRepository fileJpaRepository;

	@Autowired
	FileJdbcRepository fileJdbcRepository;

	@Test
	@Order(1)
	void fileRepositorySave()
	{
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileName( "testFile" );
		fileInfo.setContents( "file save contents".getBytes() );

		FileInfo persist = fileJpaRepository.save(fileInfo);
		Assertions.assertThat(persist).isNotNull();
		Assertions.assertThat(persist.getId()).isNotNull();
	}

	@Test
	@Order(2)
	void fileJdbcRepositorySave()
	{
		FileInfoDTO fileInfoDTO = new FileInfoDTO();
		fileInfoDTO.setFileName("testfile");
		fileInfoDTO.setContents("this is contens".getBytes());

		fileJdbcRepository.save(fileInfoDTO);
	}

}
