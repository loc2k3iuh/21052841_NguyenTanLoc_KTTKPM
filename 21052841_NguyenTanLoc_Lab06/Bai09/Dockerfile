# Sử dụng image Redis chính thức
FROM redis:latest

# Sao chép file redis.conf vào thư mục cấu hình trong container
COPY redis.conf /usr/local/etc/redis/redis.conf

# Mở cổng mặc định của Redis
EXPOSE 6379

# Sử dụng file redis.conf khi khởi động Redis
CMD ["redis-server", "/usr/local/etc/redis/redis.conf"]
