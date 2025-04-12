# Sử dụng image PostgreSQL chính thức
FROM postgres:15

# Sao chép file SQL vào thư mục để PostgreSQL tự động chạy khi khởi động lần đầu
COPY init.sql /docker-entrypoint-initdb.d/

# Thiết lập biến môi trường (nếu cần)
ENV POSTGRES_USER=admin
ENV POSTGRES_PASSWORD=admin123
ENV POSTGRES_DB=my_database
