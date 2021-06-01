package com.miyani.sample.spring.boot.jpa;

import com.miyani.sample.spring.boot.jpa.dto.FileInfoDTO;
import com.miyani.sample.spring.boot.jpa.dto.GroupInfoDTO;
import com.miyani.sample.spring.boot.jpa.dto.UserInfoDTO;
import com.miyani.sample.spring.boot.jpa.entity.FileInfo;
import com.miyani.sample.spring.boot.jpa.repository.FileJdbcRepository;
import com.miyani.sample.spring.boot.jpa.repository.FileJpaRepository;
import com.miyani.sample.spring.boot.jpa.repository.GroupRepository;
import com.miyani.sample.spring.boot.jpa.service.FileService;
import com.miyani.sample.spring.boot.jpa.service.GroupService;
import com.miyani.sample.spring.boot.jpa.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class JpaSampleApplicationTests {

	@Autowired
	FileService fileService;

	@Autowired
	GroupService groupService;

	@Autowired
	UserService userService;

	@Autowired
	FileJpaRepository fileJpaRepository;

	@Autowired
	FileJdbcRepository fileJdbcRepository;

	@Autowired
	GroupRepository groupRepository;

	@Test
	@Order(1)
	@Disabled
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
	@Disabled
	void fileJdbcRepositorySave()
	{
		FileInfoDTO fileInfoDTO = new FileInfoDTO();
		fileInfoDTO.setFileName("testfile");
		fileInfoDTO.setContents("this is contens".getBytes());

		fileJdbcRepository.save(fileInfoDTO);
	}

	@Test
	@Disabled
	void groupAdd() {
		GroupInfoDTO groupInfoDTO = new GroupInfoDTO();
		groupInfoDTO.setGroupId("A_GROUP");
		groupInfoDTO.setGroupName("A_GROUP");
		groupInfoDTO.setParentGroupId("4");
		groupInfoDTO.setDescription("A_GROUP_DESC");
		groupInfoDTO.setUseYn("Y");

		List<GroupInfoDTO> groupInfoDTOS = this.groupService.addGroup(Stream.of(groupInfoDTO).collect(Collectors.toList()));
		groupInfoDTOS.stream().forEach(System.out::println);
	}

	@Test
	void UserAdd() {
		UserInfoDTO dto = new UserInfoDTO();
		dto.setUserId("99999999");

		this.userService.checkUser(dto);
	}

}
