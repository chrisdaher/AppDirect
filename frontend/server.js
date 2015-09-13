var express = require('express');
var path = require('path');
var app = express();
app.get("/", function(req, res) {
  res.render('./index.html');
});

app.engine('ejs', require('ejs-locals'));
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');
  
var http = require('http').Server(app);
var port = 3000;
http.listen(port);
