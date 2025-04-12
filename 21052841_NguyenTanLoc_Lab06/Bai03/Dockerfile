# Sử dụng node:18-alpine làm base image
FROM node:18-alpine

# Đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép file package.json và package-lock.json vào container
COPY package*.json ./

# Cài đặt các thư viện cần thiết
RUN npm install

# Sao chép toàn bộ mã nguồn vào container
COPY . .

# Build ứng dụng React
RUN npm run build

# Cung cấp cổng 3000 cho ứng dụng React
EXPOSE 3000

# Lệnh để chạy ứng dụng sau khi build
CMD ["npm", "start"]
