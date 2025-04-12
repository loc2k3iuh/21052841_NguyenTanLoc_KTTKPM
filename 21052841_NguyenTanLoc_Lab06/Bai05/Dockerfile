# Sử dụng golang:1.18 làm base image
FROM golang:1.18

# Đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép go.mod và go.sum vào container
COPY go.mod go.sum ./

# Cài đặt các dependencies
RUN go mod download

# Sao chép mã nguồn vào container
COPY . .

# Biên dịch ứng dụng Go
RUN go build -o main .

# Mở cổng 8080
EXPOSE 8080

# Lệnh chạy ứng dụng Go
CMD ["./main"]
