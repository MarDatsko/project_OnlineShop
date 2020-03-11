/*Insert table accounts*/
INSERT INTO public.accounts(id, email, password, username)VALUES (1,'yura@gmail.com' , '1111', 'Yura');
INSERT INTO public.accounts(id, email, password, username)VALUES (2,'marik@gmail.com' , '2222', 'Marian');
INSERT INTO public.accounts(id, email, password, username)VALUES (3,'tetyana@gmail.com' , '3333', 'Tetyana');
INSERT INTO public.accounts(id, email, password, username)VALUES (4,'vlad@gmail.com' , '4444', 'Vlad');
INSERT INTO public.accounts(id, email, password, username)VALUES (5,'max@gmail.com' , '5555', 'Max');
INSERT INTO public.accounts(id, email, password, username)VALUES (6,'admin@gmail.com' , '0000', 'admin');


/*Insert table users*/
INSERT INTO public.users(id, age, first_name, last_name, phone_number, role, user_status, account_id)
VALUES (1,21,'Yura', 'Vons', '091111', 'USER', 'ACTIVE', 1);
INSERT INTO public.users(id, age, first_name, last_name, phone_number, role, user_status, account_id)
VALUES (2,20,'Marian', 'Datsko', '092222', 'USER', 'ACTIVE', 2);
INSERT INTO public.users(id, age, first_name, last_name, phone_number, role, user_status, account_id)
VALUES (3,18,'Tetyana', 'Bakhmat', '093333', 'USER', 'ACTIVE', 3);
INSERT INTO public.users(id, age, first_name, last_name, phone_number, role, user_status, account_id)
VALUES (4,45,'Vlad', 'Rembo', '094444', 'USER', 'ACTIVE', 4);
INSERT INTO public.users(id, age, first_name, last_name, phone_number, role, user_status, account_id)
VALUES (5,60,'Max', 'Mad', '095555', 'USER', 'ACTIVE', 5);
INSERT INTO public.users(id, age, first_name, last_name, phone_number, role, user_status, account_id)
VALUES (6,20,'admin', 'admin', '090000', 'ADMIN', 'ACTIVE', 6);

/*Insert table categories*/
INSERT INTO public.categories(id, description, path_to_image, user_id)
VALUES (1, 'Laptop', 'path/laptop', 6);
INSERT INTO public.categories(id, description, path_to_image, user_id)
VALUES (2, 'Monitors', 'path/monitors', 6);
INSERT INTO public.categories(id, description, path_to_image, user_id)
VALUES (3, 'Printer', 'path/printer', 6);

/*Insert table categories*/
INSERT INTO public.positions(id, availability, description, position_name, price, stock, user_id)
VALUES (1, true, 'Curved Frameless Gaming Monitor, FHD 1080p, 1500R VA panel, 1ms 144Hz, FreeSync, Height adjustable, VESA, 3-Year Zero Dead Pixels', 'AOC 24',144.99 , 3, null);
INSERT INTO public.positions(id, availability, description, position_name, price, stock, user_id)
VALUES (2, true, 'LCD Monitor SE2719H IPS Full HD 1080p 1920 x 1080 at 60 Hz HDMI VGA,Black', 'Dell 27 ',130.20 , 2, null);
INSERT INTO public.positions(id, availability, description, position_name, price, stock, user_id)
VALUES (3, true, 'Curved UltraWide WQHD IPS Monitor', 'LG 34',519.99 , 1, null);
INSERT INTO public.positions(id, availability, description, position_name, price, stock, user_id)
VALUES (4, true, 'Intel Core i7-8550U, Intel UHD Graphics 620, 1TB HDD', 'HP Pavilion',799.99 , 5, null);
INSERT INTO public.positions(id, availability, description, position_name, price, stock, user_id)
VALUES (5, true, 'NVIDIA GeForce GTX 1650, 16GB RAM, 256GB PCIe Nvme SSD + 1TB HDD, Windows 10 Home, K571GT-EB76', 'ASUS Vivobook',1049.99 , 2, null);
INSERT INTO public.positions(id, availability, description, position_name, price, stock, user_id)
VALUES (6, true, 'Quard-Core i7 1065G7 up to 3.9GHz, 8GB DDR4 RAM, 256GB SSD', 'Lenovo Ideapad',689.00 , 1, null);
INSERT INTO public.positions(id, availability, description, position_name, price, stock, user_id)
VALUES (7, true, 'Color Printer, Amazon Dash Replenishment Ready', 'Xerox Phaser',230.92 , 6, null);
INSERT INTO public.positions(id, availability, description, position_name, price, stock, user_id)
VALUES (8, true, 'All-in-One Wireless Printer, Smart Home Office Productivity', 'HP OfficeJet Pro',91.90 , 10, null);
INSERT INTO public.positions(id, availability, description, position_name, price, stock, user_id)
VALUES (9, true, 'll in One, Wireless, Mobile Ready, Duplex Laser Printer, White, Mid Size', 'Canon Color',91.90 , 2, null);

/*Insert table position_category*/
INSERT INTO public.position_category(position_id, category_id)
VALUES (1, 1);
INSERT INTO public.position_category(position_id, category_id)
VALUES (2, 1);
INSERT INTO public.position_category(position_id, category_id)
VALUES (3, 1);
INSERT INTO public.position_category(position_id, category_id)
VALUES (4, 2);
INSERT INTO public.position_category(position_id, category_id)
VALUES (5, 2);
INSERT INTO public.position_category(position_id, category_id)
VALUES (6, 2);
INSERT INTO public.position_category(position_id, category_id)
VALUES (7, 3);
INSERT INTO public.position_category(position_id, category_id)
VALUES (8, 3);
INSERT INTO public.position_category(position_id, category_id)
VALUES (9, 3);

/*Insert table orders_item*/
INSERT INTO public.orders_item(id, name, item_price, quantity)
VALUES (1, 'HP OfficeJet Pro', 91.90, 2);
INSERT INTO public.orders_item(id, name, item_price, quantity)
VALUES (2, 'Xerox Phaser',230.92 , 1);
INSERT INTO public.orders_item(id, name, item_price, quantity)
VALUES (3, 'HP Pavilion',799.99 , 1);

/*Insert table orders*/
INSERT INTO public.orders(id, date, order_number, order_price, user_id)
VALUES (1, DATE '2015-12-17', 1, 1214.71, 2);

/*Insert table order_order_item*/
INSERT INTO public.order_order_item(order_id, item_id)
VALUES (1, 1);
INSERT INTO public.order_order_item(order_id, item_id)
VALUES (1, 2);
INSERT INTO public.order_order_item(order_id, item_id)
VALUES (1, 3);
