package com.task.service;

import java.util.List;

import com.task.dto.LoginDto;
import com.task.dto.ProductDto;

public interface CommonService {

	public Boolean doLogin(LoginDto loginDto);

	public List<ProductDto> getUserProducts(String userId);

	public ProductDto addUserProduct(ProductDto product, String userId);

	public ProductDto updateUserProduct(ProductDto product, String userId);

	public Boolean deleteUserProduct(Long productId, String userId);
}
