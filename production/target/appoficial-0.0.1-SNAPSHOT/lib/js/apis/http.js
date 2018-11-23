var router = require('./router');
var db = require('./db_json.js');
var app = router(3001);

var operadoras = [];

var contatos = [];

app.interceptor(function (req, res, next) {
  res.setHeader('Access-Control-Allow-Origin', '*');
  res.setHeader('Access-Control-Allow-Headers', 'Content-Type, Authorization');
  next();
});

app.interceptor(function (req, res, next) {
  res.setHeader('Content-Type', 'application/json;charset=UTF-8');
  next();
});

app.get('/operadoras', function (req, res) {
  res.write(JSON.stringify(operadoras));
  res.end();
});

app.get('/contatos', function (req, res) {
  res.write(JSON.stringify(contatos));
  res.end();
});

app.post('/operadoras', function (req, res) {
  var operadora = req.body;
  operadoras.push(JSON.parse(operadora));
  var fileJson = db.getData();
  fileJson.push(JSON.parse(operadora));
  db.saveData(fileJson);
  res.end();
});

app.post('/file', function (req, res) {
  console.log(req.body);
  res.end();
});

app.options('/file', function (req, res) {
  res.end();
});

app.options('/operadoras', function (req, res) {
  res.end();
});

