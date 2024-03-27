package com.example.lkmt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @Column(name = "productName",length = 50)
    /*@Size(max = 50, message = "Tên sản phẩm không quá 50 kí tự")
    @NotNull(message = "Tên sản phẩm không được để trống")*/
    private String productName;

    @Column(name = "imgProduct", columnDefinition = "TEXT")
    private String imgProduct;


    @Column(name = "price")
    @NotNull(message = "Giá tiền sản phẩm không được để trống")
    @Positive(message = "Giá tiền không được bằng 0")
    private double price;

    @Column(name = "description")
    @Size(max = 150, message = "Mô tả sản phẩm không quá 150 kí tự")
    @NotNull(message = "Mô tả không được để trống")
    private String description;

    @Column(name = "quantity")
    @NotNull(message = "Số lượng không được để trống")
    private Integer quantity;

    @Column(name = "warranty")
    @NotNull(message = "Thời gian bảo hành không được để trống")
    private String warranty;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    public void setImgProduct(MultipartFile imgProduct) {
        if (imgProduct != null && !imgProduct.isEmpty()) {
            try {
                byte[] imageData = imgProduct.getBytes();
                String base64Image = Base64.getEncoder().encodeToString(imageData);
                this.imgProduct = base64Image;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public Category getCategory() {
        return category;
    }
    public void setImage(byte[] image) {
        this.imgProduct = Base64.getEncoder().encodeToString(image);
    }
}
