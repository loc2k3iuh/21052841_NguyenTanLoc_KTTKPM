# Dùng image Node.js chính thức
FROM node:18

# Tạo thư mục app
WORKDIR /app

# Copy file package.json trước
COPY package.json ./

# Cài đặt thư viện
RUN npm install

# Copy toàn bộ code vào
COPY . .

# Chạy app
CMD ["npm", "start"]
