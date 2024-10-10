package org.factoriaf5.digital_academy.funko_shop.user;

import java.util.*;

import org.factoriaf5.digital_academy.funko_shop.account_settings.AccountSettingsDTO;
import org.factoriaf5.digital_academy.funko_shop.cart.CartDTO;
import org.factoriaf5.digital_academy.funko_shop.order.OrderDTO;
import org.factoriaf5.digital_academy.funko_shop.profile.ProfileDTO;
import org.factoriaf5.digital_academy.funko_shop.review.ReviewDTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    
    private Long id;
    private String email;
    private String password;
    private ProfileDTO profile;
    private Role roles;
    private List<ReviewDTO> reviews;
    private AccountSettingsDTO accountSettings;
    private List<OrderDTO> orders;
    private CartDTO cart;
}
