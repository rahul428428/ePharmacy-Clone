package com.ePharmacy.ePharmacy_App.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Cart_Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartItem_id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne
    @JsonBackReference(value = "CartItem")
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private int quantity;
    private int total;
}
