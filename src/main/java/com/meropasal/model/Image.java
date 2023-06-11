package com.meropasal.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Image {
    @Id
    private int imageId;
    private String imageName;

}
