package com.miyani.sample.spring.boot.jpa.service;

import com.miyani.sample.spring.boot.jpa.dto.UserInfoDTO;
import com.miyani.sample.spring.boot.jpa.entity.UserGroup;
import com.miyani.sample.spring.boot.jpa.entity.UserInfo;
import com.miyani.sample.spring.boot.jpa.repository.GroupRepository;
import com.miyani.sample.spring.boot.jpa.repository.UserGroupRepository;
import com.miyani.sample.spring.boot.jpa.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService
{
    private final UserRepository userRepository;
    private final UserGroupRepository userGroupRepository;
    private final GroupRepository groupRepository;
    private final LdapService ldapService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserGroupRepository userGroupRepository, GroupRepository groupRepository, LdapService ldapService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userGroupRepository = userGroupRepository;
        this.groupRepository = groupRepository;
        this.ldapService = ldapService;
        this.modelMapper = modelMapper;
    }

    public UserInfo checkUser(UserInfoDTO userInfoDTO)
    {
        return userRepository.findById(userInfoDTO.getUserId()).orElseGet(() -> {
            return this.ldapUserAdd(userInfoDTO);
        });
    }


    private UserInfo ldapUserAdd(UserInfoDTO userInfoDTO)
    {
        if (ldapService.existsUser(userInfoDTO.getUserId())) {
            UserInfoDTO ldapUser = ldapService.getUser(userInfoDTO.getUserId());
            UserInfo userInfo = this.modelMapper.map(ldapUser, UserInfo.class);

            List<UserGroup> userGroupList = groupRepository.findByParentGroupId("4").stream().map(it -> {
                UserGroup userGroup = new UserGroup();
                userGroup.setGroupInfo(it);
                userGroup.setUserInfo(userInfo);
                userGroup.setIsAdmin("Y");
                userGroup.setIsDefault("Y");

                System.out.println(it.getGroupId());

                return userGroup;
            }).collect(Collectors.toList());

            userGroupRepository.saveAll(userGroupList);
            userGroupList.forEach(userInfo::addGroup);

            return userRepository.save(userInfo);
        }
        else {
            throw new RuntimeException("유저정보가 존재하지 않음.");
        }
    }
}
