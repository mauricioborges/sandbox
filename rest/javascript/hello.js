var express = require('express'); // aqui é maaais ou menos um import. o require é uma característica do node.js
var app = express(); //entendeu? o express é um módulo que exporta uma função base "express". https://github.com/strongloop/express/blob/master/lib/express.js#L27

app.get('/', function (req, res) { //Essa linha tá definindo uma rota, ou seja, a raiz da aplicação vai rodar o código dentro da função. a função app.get tem a sintaxe app.get('path', funcao)
  res.send('Hello World!'); //duck typing: o código espera que o objeto res tenha a função send.
});

var server = app.listen(3000, function () {//aqui é onde começa tudo. a função app.listen recebe como parametro uma porta e uma função de callback que vai ser executada quando ele estiver no ar

  var host = server.address().address; //loca essa asincronia né? esse server aqui é o mesmo de fora. funciona porque essa função de callback só é chamada depois que o objeto é atribuído a server.
  var port = server.address().port;

  console.log('Example app listening at http://%s:%s', host, port); //console.log igual o browse, tá ligado?
});
