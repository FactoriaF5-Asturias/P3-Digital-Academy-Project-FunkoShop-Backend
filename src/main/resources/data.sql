-- Users
INSERT INTO users (user_id, email, password, role) VALUES (default, 'user@gmail.com', '$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO', 'USER');
INSERT INTO users (user_id, email, password, role) VALUES (default, 'admin@gmail.com', '$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO', 'ADMIN');


-- Profiles
INSERT INTO profiles (first_name, last_name, phone_number, street, city, region, postal_code, country, user_id, is_shipping, is_subscribed) VALUES
('Carlos', 'Gómez', '5551234567', '123 Avenida Principal', 'Ciudad de México', 'CDMX', '01000', 'México', 1, false, false),
('Sofía', 'Martínez', '5559876543', '456 Calle Secundaria', 'Guadalajara', 'Jalisco', '44100', 'México', 2, true, true);

-- Categories
INSERT INTO categories (category_id, name, highlights, image_hash) VALUES (default, 'Animation', false, 'http://localhost:5173/src/assets/img/Carrousel/animation.jpg'),
 (default, 'Anime & Manga', true, 'http://localhost:5173/src/assets/img/Carrousel/anime.jpg'),
 (default, 'Marvel', true, 'http://localhost:5173/src/assets/img/Carrousel/marvel.jpg'),
 (default, 'DC Comics', false, 'http://localhost:5173/src/assets/img/Carrousel/dc-comics.jpg');


 -- Additional Products
INSERT INTO products (product_id, name, image, description, price, stock, category_id, discount, created_at) VALUES
(default, 'Spider-Man', 'spiderman.jpg', 'A collectible Spider-Man figure from Marvel.', 12.99, 50, 3, 10, '2024-01-01 10:00:00'),
(default, 'Batman', 'batman.jpg', 'A collectible Batman figure from DC Comics.', 11.99, 40, 4, 20, '2024-02-01 11:30:00'),
(default, 'Goku Super Saiyan', 'goku.jpg', 'Goku in his Super Saiyan form from Dragon Ball Z.', 14.99, 0, 2, 0, '2024-03-01 12:00:00'),
(default, 'Sailor Moon', 'sailormoon.jpg', 'Sailor Moon figure from the classic anime series.', 13.99, 20, 2, 0, '2024-01-15 09:00:00'),
(default, 'Mickey Mouse', 'mickey.jpg', 'Classic Mickey Mouse collectible figure.', 9.99, 60, 1, 0, '2024-01-10 14:00:00'),
(default, 'Iron Man', 'ironman.jpg', 'Iron Man figure with metallic finish.', 15.99, 25, 3, 0, '2024-01-20 16:45:00'),
(default, 'Wonder Woman', 'wonderwoman.jpg', 'Wonder Woman figure from DC Comics.', 12.49, 35, 4, 0, '2024-02-05 13:15:00'),
(default, 'Naruto Uzumaki', 'naruto.jpg', 'Naruto figure in his classic outfit.', 13.49, 45, 2, 0, '2024-01-25 11:45:00'),
(default, 'SpongeBob SquarePants', 'spongebob.jpg', 'SpongeBob figure from the animated series.', 10.99, 50, 1, 0, '2024-03-01 10:30:00'),
(default, 'Captain America', 'captainamerica.jpg', 'Captain America with his shield.', 12.99, 30, 3, 0, '2024-03-05 15:00:00'),
(default, 'Thanos', 'thanos.jpg', 'Thanos figure with Infinity Gauntlet.', 16.99, 15, 3, 0, '2024-02-20 17:20:00'),
(default, 'Joker', 'joker.jpg', 'Joker figure from DC Comics.', 11.49, 40, 4, 0, '2024-01-18 12:30:00'),
(default, 'Luffy', 'luffy.jpg', 'Monkey D. Luffy from One Piece.', 14.49, 35, 2, 0, '2024-02-25 09:15:00'),
(default, 'Elsa', 'elsa.jpg', 'Elsa figure from Frozen.', 13.99, 25, 1, 0, '2024-02-10 13:50:00'),
(default, 'Deadpool', 'deadpool.jpg', 'Deadpool in a classic pose.', 12.99, 50, 3, 0, '2024-02-01 12:10:00'),
(default, 'Superman', 'superman.jpg', 'Superman figure from DC Comics.', 12.99, 45, 4, 0, '2024-03-01 08:45:00'),
(default, 'Vegeta', 'vegeta.jpg', 'Vegeta from Dragon Ball Z.', 14.99, 30, 2, 0, '2024-01-05 10:10:00'),
(default, 'Pikachu', 'pikachu.jpg', 'Pikachu figure from Pokémon.', 11.99, 60, 2, 0, '2024-01-15 14:50:00'),
(default, 'Harley Quinn', 'harleyquinn.jpg', 'Harley Quinn figure from DC Comics.', 12.49, 35, 4, 40, '2024-02-18 10:20:00'),
(default, 'Black Panther', 'blackpanther.jpg', 'Black Panther figure from Marvel.', 13.99, 25, 3, 40, '2024-03-10 11:30:00'),
(default, 'Thor', 'thor.jpg', 'Thor figure with Mjolnir.', 15.99, 20, 3, 0, '2024-03-01 08:45:00'),
(default, 'Hulk', 'hulk.jpg', 'Hulk figure from Marvel.', 14.99, 30, 3, 40, '2024-03-01 08:45:00'),
(default, 'Groot', 'groot.jpg', 'Groot figure from Guardians of the Galaxy.', 12.99, 40, 3, 40, NOW()),
(default, 'Fluttershy', 'fluttershy.jpg', 'Fluttershy figure from My Little Pony.', 11.99, 50, 1, 20, NOW());



-- -- Orders
-- INSERT INTO orders (order_id, status, total_price, total_items, is_paid, user_id) VALUES
-- (default, 'PENDING', 19.99, 1, true, 1),
-- (default, 'PENDING', 89.99, 5, true, 2);


-- --  OrderItems
-- INSERT INTO order_items (order_item_id, quantity, order_id, product_id)
-- VALUES (default, 2, 1, 1);
-- INSERT INTO order_items (order_item_id, quantity, order_id, product_id)
-- VALUES (default, 3, 1, 1);

-- Reviews
-- INSERT INTO reviews (review_id, rating, order_item_id, user_id) VALUES (default, 5, 1, 1);
-- INSERT INTO reviews (review_id, rating, order_item_id, user_id) VALUES (default, 4, 2, 1);