package com.miyani.sample.spring.boot.jpa.service;

import com.miyani.sample.spring.boot.jpa.dto.UserInfoDTO;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class LdapService
{
    private final Set<String> ldapUserSet = Stream.of("99999999", "88888888").collect(Collectors.toSet());

    public boolean existsUser(final String userId) {
        return this.ldapUserSet.contains(userId);
    }

    public UserInfoDTO getUser(String userId)
    {
        UserInfoDTO dto = new UserInfoDTO();
        dto.setUserId( userId );
        dto.setDeptCode( "ldap");

        return dto;
    }
}
