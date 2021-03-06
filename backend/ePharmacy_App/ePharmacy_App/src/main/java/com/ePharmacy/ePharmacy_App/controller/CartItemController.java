package com.ePharmacy.ePharmacy_App.controller;


import com.ePharmacy.ePharmacy_App.entity.Cart_Item;
import com.ePharmacy.ePharmacy_App.entity.Product;
import com.ePharmacy.ePharmacy_App.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CartItemController {

    @Autowired
    CartItemService cartItemService;

   @PostMapping("/addtocart/users/{userid}/product/{pdid}")
   public String addtoCart(@RequestBody Cart_Item cartItem, @PathVariable("userid") Long userId , @PathVariable("pdid") Long productId ){

       System.out.println("Iam in Cart controller add to cart");

      return  cartItemService.addtoCart(userId,productId, cartItem.getQuantity());

   }

   @GetMapping("/cartItems/user/{userid}")
   public  List<Cart_Item> getItemsinCart(@PathVariable("userid") Long userId){
       return  cartItemService.getItemsinCart(userId);
   }

   @DeleteMapping("/delete/Item/{cart_item_id}")
   public String deleteCartItem(@PathVariable("cart_item_id")  Long cartItemId){
    return cartItemService.deleteCartItem(cartItemId);
   }

}
