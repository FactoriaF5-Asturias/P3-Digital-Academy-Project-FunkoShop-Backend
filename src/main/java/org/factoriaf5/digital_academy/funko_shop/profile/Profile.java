package org.factoriaf5.digital_academy.funko_shop.profile;

import org.factoriaf5.digital_academy.funko_shop.address.Address;
import org.factoriaf5.digital_academy.funko_shop.user.User;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;

    private String street;

    private String city;

    private String region;
    @Column(name = "postal_code")
    private String postalCode;

    private String country;

    @JsonIgnore
    @Column(name = "is_shipping", columnDefinition = "boolean default false")
    private boolean isShipping;

    @JsonIgnore
    @Column(name = "is_subscribed", columnDefinition = "boolean default false")
    private boolean isSubscribed;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = true)
    private Address address;

}
