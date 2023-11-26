package yunsinsa.yunsinsashop.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;

public class MemberDto {

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    public static class CreateRequest {
        @NotNull
        private String name;
        @NotNull
        private String email;
        @NotNull
        private String password;
        @NotNull
        private String street;
        @NotNull
        private String city;
        @NotNull
        private String state;
        @NotNull
        private int zipcode;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class UpdateRequest {
        private Long id;
        private String name;
        private String email;
        private String password;
        private String street;
        private String city;
        private String state;
        private int zipcode;
    }

    @Setter
    @Getter
    @Builder
    @AllArgsConstructor
    public static class CreateResponse {
        private String name;
        private String email;
        private String street;
        private String city;
        private String state;
        private int zipcode;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    public static class FindResponse {
        private Long id;
        private String name;
        private String email;
    }
}
