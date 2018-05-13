package com.task.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.task.dto.LoginDto;
import com.task.dto.ProductDto;
import com.task.dto.Response;
import com.task.service.CommonService;


@Controller
@RequestMapping(value="api")
public class RestController {

	private Logger logger = LoggerFactory.getLogger(RestController.class);

	@Autowired
	private CommonService commonService;

	@RequestMapping(value = "login", method=RequestMethod.POST)
	public @ResponseBody Response generateSalesBillInvoiceNumber(@RequestBody LoginDto login) {
		logger.info("Loggin request: " + login.toString());
		Response response = null;
		if (commonService.doLogin(login)) {
			logger.debug("Loggin Success: " + login.toString());
			response = new Response("Success", true, true);
		} else {
			response = new Response("Error", false, false);
		}
		return response;
	}

	@RequestMapping(value="products/user/{userId}", method = RequestMethod.GET)
	public @ResponseBody Response getUserProducts(@PathVariable("userId") String userId) {
		logger.info("Fetch user products: " + userId);
		Response response = new Response("Success", true, commonService.getUserProducts(userId));
		return response;
	}

	@RequestMapping(value = "products/user/{userId}", method = RequestMethod.POST)
	public @ResponseBody Response saveUserProducts(@PathVariable("userId") String userId, @RequestBody ProductDto product) {
		logger.info("Fetch user products: " + userId);
		Response response = new Response("Success", true, commonService.addUserProduct(product, userId));
		return response;
	}

	@RequestMapping(value = "products/user/{userId}", method = RequestMethod.PUT)
	public @ResponseBody Response updateUserProducts(@PathVariable("userId") String userId, @RequestBody ProductDto product) {
		logger.info("Fetch user products: " + userId);
		Response response = new Response("Success", true, commonService.updateUserProduct(product, userId));
		return response;
	}

	@RequestMapping(value = "products/user/{userId}/{productId}", method = RequestMethod.DELETE)
	public @ResponseBody Response UserProducts(@PathVariable("userId") String userId, @PathVariable("productId") Long productId) {
		logger.info("Fetch user products: " + userId);
		Response response = new Response("Success", true, commonService.deleteUserProduct(productId, userId));
		return response;
	}
}
