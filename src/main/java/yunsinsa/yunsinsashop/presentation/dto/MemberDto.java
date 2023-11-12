package yunsinsa.yunsinsashop.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;

@Setter
@Getter
@AllArgsConstructor
public class MemberDto {
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    public static class CreateRequest{
        private String name;
        private String email;
        private String password;
        private String street;
        private String city;
        private String state;
        private int zipcode;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class UpdateRequest{
        private Long id;
        private String name;
        private String email;
        private String password;
        private String address;

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



}
