-- 插入USER表演示数据
INSERT INTO USER (email, password, first_name, last_name, country, phone)
VALUES
    ('user1@example.com', 'password1', 'John', 'Doe', 'USA', '1234567890'),
    ('user2@example.com', 'password2', 'Jane', 'Smith', 'UK', '0987654321');

-- 插入PASSENGER表演示数据
INSERT INTO PASSENGER (booking_id, first_name, last_name, email)
VALUES
    (NULL, 'Alice', 'Johnson', 'alice@example.com'),
    (NULL, 'Bob', 'Williams', 'bob@example.com');

-- 插入BOOKING表演示数据
INSERT INTO BOOKING (user_id, flight_id, reference, status, booking_time, total_price)
VALUES
    (1, 1, 'REF123', 'CONFIRMED', NOW(), 250.50),
    (2, 2, 'REF456', 'PENDING', NOW(), 300.75);

-- 插入AIRPORT表演示数据
INSERT INTO AIRPORT (code, name, city)
VALUES
    ('JFK', 'John F. Kennedy Airport', 'New York'),
    ('LHR', 'London Heathrow Airport', 'London');

-- 插入FLIGHT表演示数据
INSERT INTO FLIGHT (flight_number, departure_airport_id, destination_airport_id, departure_date, departure_time, price)
VALUES
    ('AA123', 1, 2, '2025-07-01', '08:00:00', 200.00),
    ('BA456', 2, 1, '2025-07-02', '10:30:00', 220.50);