package com.products.payloads;

import lombok.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;
}
