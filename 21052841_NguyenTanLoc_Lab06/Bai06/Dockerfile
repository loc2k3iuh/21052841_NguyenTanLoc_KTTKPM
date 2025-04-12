# Stage 1: Build ứng dụng
FROM node:18 AS build

# Đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép package.json và package-lock.json vào container
COPY package*.json ./

# Cài đặt các dependencies
RUN npm install

# Sao chép toàn bộ mã nguồn vào container
COPY . .

# Build ứng dụng (nếu có lệnh build)
RUN npm run build

# Stage 2: Chạy ứng dụng
FROM node:18-alpine

# Đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép các file đã build từ Stage 1 vào container
COPY --from=build /app /app

# Cài đặt các dependencies chỉ cần thiết để chạy ứng dụng
RUN npm install --production

# Mở cổng mà ứng dụng sẽ chạy
EXPOSE 3000

# Lệnh chạy ứng dụng
CMD ["npm", "start"]
