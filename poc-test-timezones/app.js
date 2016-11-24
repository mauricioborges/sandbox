var express = require('express')
var request = require('request');
var app = express()
process.env.NODE_TLS_REJECT_UNAUTHORIZED = "0";

app.use('/static',express.static('static'))


app.listen(3000, function () {
    console.log('Example app listening on port 3000!')
})
