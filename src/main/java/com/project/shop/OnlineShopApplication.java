package com.project.shop;

import com.project.shop.model.*;
import com.project.shop.repository.*;
import com.project.shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class OnlineShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineShopApplication.class, args);
    }

    @Autowired
	AccountService accountService;

    @Autowired
	CategoryService categoryService;

	@Autowired
	OrderItemService orderItemService;

	@Autowired
	OrderService orderService;

	@Autowired
	PositionService positionService;

	@Autowired
    UserService userService;




    @Bean
    public void fillDatabase() {
        Account account = new Account();
        account.setUserName("marik");
        account.setEmail("maric@gmail.com");
        account.setPassword("1111");

        User user = new User();
        user.setFirstName("Marian");
        user.setLastName("Datsko");
        user.setAge(21);
        user.setPhone("0962507864");
        user.setRole(Role.USER);
        user.setUserStatus(UserStatus.INACTIVE);
        user.setAccount(account);

		Category category = new Category();
		category.setDescription("Fresh dairy products");
		category.setImagePath("d/img/milk");
		category.setUserId(user);

		Position position = new Position();
		position.setAvailability(true);
		position.setDescription("Very cool products");
		position.setName("Milk");
		position.setPrice(BigDecimal.valueOf(40));
		position.setUserId(user);
		position.setStock(30);
		position.setListCategoryId(List.of(category));

		OrderItem orderItem = new OrderItem();
		orderItem.setPrice(position.getPrice());
		orderItem.setQuantity(2L);
		orderItem.setName(position.getName());

		Order order = new Order();
		order.setDate(new Date(2012, Calendar.APRIL,12));
		order.setItemList(List.of(orderItem));
		order.setPrice(BigDecimal.valueOf(40));
		order.setUserId(user);

		accountService.saveOrUpdate(account);
		userService.saveOrUpdate(user);
		categoryService.saveOrUpdate(category);
		positionService.saveOrUpdate(position);
		orderItemService.saveOrUpdate(orderItem);
		orderService.saveOrUpdate(order);
    }

}
