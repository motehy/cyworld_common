package com.cyworld.common.core.login.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class UserDto {

    @Getter
    @Setter
    @Schema(description="회원 리스트(검색)")
    public static class UserInfo {

        @Schema(description = "회원 아이디")
        private String userid;

        @Schema(description = "회원 비밀번호")
        private String userpw;


        @Builder
        public UserInfo(String userid, String userpw) {
            this.userid = userid;
            this.userpw = userpw;
        }
    }
}
