const express = require('express');
const app = express();
const port = 3000;

app.get('/', (req, res) => {
  res.send('Xin chào từ Node.js và Docker!');
});

app.listen(port, () => {
  console.log(`Ứng dụng đang chạy tại http://localhost:${port}`);
});