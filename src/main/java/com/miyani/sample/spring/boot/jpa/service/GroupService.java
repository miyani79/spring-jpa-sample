package com.miyani.sample.spring.boot.jpa.service;

import com.miyani.sample.spring.boot.jpa.dto.GroupInfoDTO;
import com.miyani.sample.spring.boot.jpa.entity.GroupInfo;
import com.miyani.sample.spring.boot.jpa.repository.GroupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService
{
    private final GroupRepository groupRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public GroupService(GroupRepository groupRepository, ModelMapper modelMapper) {
        this.groupRepository = groupRepository;
        this.modelMapper = modelMapper;
    }

    public List<GroupInfoDTO> addGroup(final List<GroupInfoDTO> groupList)
    {
        return this.groupRepository.saveAll(groupList.stream().map(this::convertGroupInfo).collect(Collectors.toList()))
                .stream().map(this::convertGroupInfoDTO).collect(Collectors.toList());
    }

    private GroupInfoDTO convertGroupInfoDTO(final GroupInfo groupInfo) {
        return modelMapper.map(groupInfo, GroupInfoDTO.class);
    }

    private GroupInfo convertGroupInfo(final GroupInfoDTO groupInfoDTO) {
        return modelMapper.map(groupInfoDTO, GroupInfo.class);
    }
}
