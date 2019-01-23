package com.xcaliber.foodstall.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xcaliber.foodstall.auth.service.UserUtil;
import com.xcaliber.foodstall.model.Cart;
import com.xcaliber.foodstall.model.Item;
import com.xcaliber.foodstall.model.Menu;
import com.xcaliber.foodstall.service.CartService;
import com.xcaliber.foodstall.service.ItemService;
import com.xcaliber.foodstall.views.CartForm;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;

	@Autowired
	private UserUtil userUtil;

	@Autowired
	private ItemService itemService;

	@PostMapping("/submit-item")
	protected ModelAndView onSubmit(@ModelAttribute("menuForm") Menu userForm, BindingResult bindingResult, Model model)
			throws Exception {
		System.out.println(userForm);

		List<Item> items = itemService.findByCategoryName(userForm.getOrderItem());

		ModelAndView modelAndView = new ModelAndView("check-item");
		modelAndView.addObject("cartForm", new CartForm());
		modelAndView.addObject("items", items);
		return modelAndView;
	}

	@RequestMapping(value = "/show-cart", method = RequestMethod.GET)
	public ModelAndView showCart(Model model) {

		Cart cart = cartService.getCartByUserId(userUtil.getLoggedInUser().getUserId());
		ModelAndView mv = new ModelAndView("cart-details");
		if (cart != null) {
			int total = cart.getItems().stream().mapToInt(i -> i.getPrice()).sum();
			mv.addObject("cart", cart);
			mv.addObject("total", total);

		}else {
			mv.setViewName("redirect:/welcome");
		}
		return mv;
	}

	// add-to-cart

	@RequestMapping(value = "/add-to-cart", method = RequestMethod.POST)
	public String registration(@ModelAttribute("cartForm") CartForm cartForm, BindingResult bindingResult,
			Model model) {

		System.out.println(cartForm);
		List<Integer> itemIds = cartForm.getItems();
		List<Item> items = new ArrayList();
		for (Integer itemId : itemIds) {
			Item item = itemService.findById(itemId);
			items.add(item);
		}

		cartService.addItemsToCart(items);

		return "redirect:/welcome";
	}

	@RequestMapping(value = "/create-cart", method = RequestMethod.POST)
	public String registration(@ModelAttribute("cartForm") Cart userForm, BindingResult bindingResult, Model model) {

		cartService.createCart(userForm);

		return "";
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView checkout() {

		Cart cart = cartService.getCartByUserId(userUtil.getLoggedInUser().getUserId());

		cartService.checkoutCart(cart);

		int total = cart.getItems().stream().mapToInt(i -> i.getPrice()).sum();
		ModelAndView mv = new ModelAndView("cart-details");
		mv.addObject("cart", cart);
		mv.addObject("total", total);
		return mv;
	}

}
