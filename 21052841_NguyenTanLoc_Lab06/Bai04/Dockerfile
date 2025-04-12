# Sử dụng nginx:latest làm base image
FROM nginx:latest

# Sao chép file index.html vào thư mục phục vụ của Nginx
COPY index.html /usr/share/nginx/html/

# Mở cổng 80 cho Nginx
EXPOSE 80

# Lệnh chạy Nginx (mặc định Nginx sẽ tự động chạy khi container bắt đầu)
CMD ["nginx", "-g", "daemon off;"]
