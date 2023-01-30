package org.spring.security2.config;

import lombok.RequiredArgsConstructor;
import org.spring.security2.dto.MemberDto;
import org.spring.security2.entities.Members;
import org.spring.security2.repository.MembersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MembersRepository membersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Members> result = membersRepository.findByEmail(email);
        if (!result.isPresent()) {
            throw new UsernameNotFoundException("No user found");
        }
            Members user = result.get();
            System.out.println("User is "+user);



            return Members.builder().build();

    }
}
