package org.spring.security2.service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.spring.security2.constant.Role;
import org.spring.security2.dto.MemberDto;
import org.spring.security2.entities.Members;
import org.spring.security2.repository.MembersRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServ {

    private final MembersRepository membersRepository;

    public void insert(MemberDto memberDto) {

        Members members=Members.builder()
                .email(memberDto.getEmail())
                .password(memberDto.getPassword())
                .role(Role.MEMBER.name())
                .build();
        membersRepository.save(members);
    }
}
