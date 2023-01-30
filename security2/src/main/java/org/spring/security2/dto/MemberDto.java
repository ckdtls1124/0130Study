package org.spring.security2.dto;

import lombok.*;

import javax.management.relation.Role;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDto {

    private Long id;
    @NotBlank(message = "이메일이 입력되지 않았습니다.")
    private String email;
    @NotBlank(message = "비밀번호가 입력되지 않았습니다.")
    private String password;
    private Role role;


}
