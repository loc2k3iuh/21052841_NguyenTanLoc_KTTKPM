import os

# Đọc giá trị của biến môi trường APP_ENV
app_env = os.getenv('APP_ENV', 'not set')

# In ra màn hình giá trị của biến môi trường
print(f'APP_ENV is set to: {app_env}')
