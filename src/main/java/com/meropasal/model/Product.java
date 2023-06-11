package com.meropasal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private String productDetails;
    private long productPrice;
    @OneToMany
    private List<Image> productImg;
    private String productInsDate;
    private String productExpDate;
    @ManyToOne
    private Category category;
}
