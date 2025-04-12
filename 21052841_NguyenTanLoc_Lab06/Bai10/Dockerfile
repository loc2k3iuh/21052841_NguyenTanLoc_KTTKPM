# Sử dụng image PHP với Apache
FROM php:8.2-apache

# Cài đặt PHP extensions nếu cần (ví dụ: mysqli)
RUN docker-php-ext-install mysqli

# Mở cổng Apache mặc định (80)
EXPOSE 80

# Cấu hình Apache để phục vụ ứng dụng PHP
COPY . /var/www/html/

# Apache tự động chạy khi container khởi động, không cần lệnh CMD
