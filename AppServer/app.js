var bodyParser = require('body-parser');
const express = require('express');
const fetch = require('node-fetch');
const utils = require('./utils.js')
const fs = require('fs');
const app = express();
const path = require('path');

app.use(bodyParser.urlencoded({extended: true})) 
app.use(bodyParser.json()) 
app.use((req,res,next) =>{
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    next();
    }
)
var parameters = {}
//Getting parameters from user and uploading them to our app

async function fetchAndSave(){
    const [firstInfo,secondInfo,IPInfo] = await Promise.all([
        fetch('http://api.worldbank.org/v2/country/'+parameters.yourcountry+'?format=json'),
        fetch('http://api.worldbank.org/v2/country/'+parameters.othercountry+'?format=json'),
        fetch('http://ip-api.com/json/' + parameters.IP)
    ])
    const firstCountry = await firstInfo.json();
    const secondCountry = await secondInfo.json();
    const IPDetails = await IPInfo.json();      

    return [firstCountry,secondCountry,IPDetails];
}

app.get('/', (req,res) => {
    res.sendFile(path.join(__dirname+'/index.html'));
})

app.post('/', (req,res) => {
    parameters = req.body;
    console.log('Got parameters from user:');
    console.log(parameters);
    let errCheck = "";
    if(utils.isEmptyObject(parameters))
        res.send("Could not receive parameters from POST request!");
    else
        res.send("Parameters have been uploaded to server! To check your results (or if input was bad) type in search bar /result");
})

app.get('/result',(req,res) =>{
    fetchAndSave().then(([firstCountry,secondCountry,IPDetails]) => {
        let errCheck = "";
        if(firstCountry[0].message != undefined)
            errCheck ="the first country code";
        else if (secondCountry[0].message != undefined)
            errCheck = "the second country code";
        else if (IPDetails.status != "success")
            errCheck = "IP address";
        
        if(errCheck != ""){
            res.send(`Input data had incorrect value for ${errCheck}! Please try to fill the forms again by going back to the first site`);
            return;
        }

        var data = utils.analyzeData(firstCountry,secondCountry,IPDetails);
        fs.writeFile('finished.html',utils.createHTML(data),(err) => {
            if (err)
                throw err;
        });
        res.sendFile(path.join(__dirname+'/finished.html'));
    }).catch(error => {
        throw error;
    });
})

app.get('/result.json',(req,res) =>{
    fetchAndSave().then(([firstCountry,secondCountry,IPDetails]) => {
        var data = utils.analyzeData(firstCountry,secondCountry,IPDetails);
        res.send(data);
    }).catch(error => {
        throw error;
    });
})

const port = 3000;
app.listen(port, () => {console.log(`Listening on port ${port}...`)})
