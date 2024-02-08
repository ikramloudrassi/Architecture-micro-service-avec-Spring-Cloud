package org.sid.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.billingservice.model.Product;

@Entity@NoArgsConstructor@Data@AllArgsConstructor@Builder
public class ProductItem {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
@ManyToOne
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    private int quantity;
    private double price;

    private double discount;
    @Transient
    private Product product;


}
