package org.factoriaf5.digital_academy.funko_shop.order;

import java.util.List;

import org.factoriaf5.digital_academy.funko_shop.order_item.OrderItemDTO;
import org.factoriaf5.digital_academy.funko_shop.tracking.TrackingDTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long id;
    private String status;
    private float totalPrice;
    private int totalItems;
    private boolean isPaid; 
    private List<OrderItemDTO> orderItems;
    private TrackingDTO tracking;
}
