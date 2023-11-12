package yunsinsa.yunsinsashop.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;

@Setter
@Getter
@AllArgsConstructor
public class MemberDto {
    @Getter
    @Setter
    @AllArgsConstructor
    private static class CreateRequest{
        private String name;
        private String email;
        private String password;
        private String address;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    private static class UpdateRequest{
        private Long id;
        private String name;
        private String email;
        private String password;
        private String address;

    }
}
