package com.task.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.task.dto.LoginDto;
import com.task.dto.ProductDto;
import com.task.service.CommonService;
import com.task.util.AppConstants;
import com.task.util.FileUtil;

@Service
public class CommonServiceImpl implements CommonService {
	
	private Map<String, List<ProductDto>> products = new HashMap<String, List<ProductDto>>();

	@Override
	public Boolean doLogin(LoginDto loginDto) {

		FileUtil fileUtil = new FileUtil();
		String[] userNames = fileUtil.getProperty(AppConstants.USER_NAMES).split(",");
		String password = fileUtil.getProperty(AppConstants.PASSWORD);

		for(int i=0; i<userNames.length; i++) {
			if (userNames[i].equals(loginDto.getUserId()) && password.equals(loginDto.getPassword())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<ProductDto> getUserProducts(String userId) {
		List<ProductDto> li = products.get(userId);
		if (li == null) {
			li = new ArrayList<ProductDto>();
		}
		return li;
	}

	@Override
	public ProductDto addUserProduct(ProductDto product, String userId) {
		List<ProductDto> li = products.get(userId);
		if (li == null || li.size() == 0) {
			li = new ArrayList<ProductDto>();
			products.put(userId, li);
			product.setId(1l);
		} else {
			ProductDto lastProd = li.get(li.size() - 1);
			product.setId(lastProd.getId() + 1);
		}
		li.add(product);
		return product;
	}

	@Override
	public ProductDto updateUserProduct(ProductDto product, String userId) {
		List<ProductDto> li = products.get(userId);
		if (li == null) {
			li = new ArrayList<ProductDto>();
			products.put(userId, li);
		}
		for(int i=0; i<li.size(); i++) {
			if (li.get(i).getId() == product.getId()) {
				li.set(i, product);
				break;
			}
		}
		return product;
	}

	@Override
	public Boolean deleteUserProduct(Long productId, String userId) {
		List<ProductDto> li = products.get(userId);
		Boolean isDeleted = false;
		if (li == null) {
			isDeleted = false;
		} else {
			for(int i=0; i<li.size(); i++) {
				if (li.get(i).getId() == productId) {
					li.remove(i);
					isDeleted = true;
					break;
				}
			}	
		}
		return isDeleted;
	}
}
