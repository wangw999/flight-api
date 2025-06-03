-- 创建USER表
CREATE TABLE IF NOT EXISTS USER (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(255) UNIQUE,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    country VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL
);

-- 创建PASSENGER表
CREATE TABLE IF NOT EXISTS PASSENGER (
    passenger_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    booking_id BIGINT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL
);

-- 创建BOOKING表
CREATE TABLE IF NOT EXISTS BOOKING (
    booking_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    flight_id BIGINT,
    reference VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    booking_time TIMESTAMP NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL
);

-- 创建AIRPORT表
CREATE TABLE IF NOT EXISTS AIRPORT (
    airport_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(10) NOT NULL,
    name VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL
);

-- 创建FLIGHT表
CREATE TABLE IF NOT EXISTS FLIGHT (
    flight_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    flight_number VARCHAR(10) NOT NULL,
    departure_airport_id BIGINT,
    destination_airport_id BIGINT,
    departure_date DATE NOT NULL,
    departure_time TIME NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);