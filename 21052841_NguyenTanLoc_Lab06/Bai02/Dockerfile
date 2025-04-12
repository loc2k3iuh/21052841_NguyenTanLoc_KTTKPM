# Sử dụng base image python 3.9
FROM python:3.9

# Đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép file requirements.txt vào container
COPY requirements.txt /app/

# Cài đặt các thư viện yêu cầu
RUN pip install -r requirements.txt

# Sao chép toàn bộ mã nguồn vào thư mục làm việc
COPY . /app/

# Mở cổng 5000 để ứng dụng Flask có thể chạy
EXPOSE 5000

# Lệnh chạy ứng dụng Flask
CMD ["python", "app.py"]
