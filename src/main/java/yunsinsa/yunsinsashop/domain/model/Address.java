package yunsinsa.yunsinsashop.domain.model;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable  // 해당 어노테이션이 지정된 클래스의 인스턴스는 다른 엔터티 클래스에 속성으로 포함 있는것을 의미
public class Address {

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zipcode")
    private int zipcode;

    @Builder
    public Address(String street, String city, String state, int zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return city + " " + state + " 우편번호: " + zipcode;
    }
}
