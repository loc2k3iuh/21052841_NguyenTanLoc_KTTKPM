zconst express = require('express');
const mysql = require('mysql2');

const app = express();
const port = 3000;

// Lấy thông tin DB từ biến môi trường
const connection = mysql.createConnection({
  host: process.env.DB_HOST,
  user: process.env.DB_USER,
  password: process.env.DB_PASSWORD,
  database: process.env.DB_NAME
});

connection.connect(err => {
  if (err) {
    console.error('❌ MySQL connection error:', err);
    return;
  }
  console.log('✅ Connected to MySQL database');
});

app.get('/', (req, res) => {
  connection.query('SELECT NOW() AS now', (err, results) => {
    if (err) return res.status(500).send('DB error');
    res.send(`MySQL Time: ${results[0].now}`);
  });
});

app.listen(port, () => {
  console.log(`🚀 Node app listening at http://localhost:${port}`);
});
