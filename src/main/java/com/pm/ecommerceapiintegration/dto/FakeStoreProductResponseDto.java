package com.pm.ecommerceapiintegration.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreProductResponseDto {
	private ProductDto product;
	private String message;
	private String status;
}