package com.meropasal.model.dto;

import com.meropasal.model.Category;
import com.meropasal.model.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
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
