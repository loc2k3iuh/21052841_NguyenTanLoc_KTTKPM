# Sử dụng image Python chính thức
FROM python:3.9

# Đặt thư mục làm việc trong container
WORKDIR /app

# Cài đặt các dependencies (nếu có)
COPY requirements.txt ./
RUN pip install --no-cache-dir -r requirements.txt

# Đặt biến môi trường
ENV APP_ENV=development

# Sao chép mã nguồn vào container
COPY . .

# Lệnh chạy ứng dụng Python
CMD ["python", "app.py"]
