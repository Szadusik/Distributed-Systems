function isEmptyObject(obj) {
    for (var key in obj) {
      if (Object.prototype.hasOwnProperty.call(obj, key)) {
        return false;
      }
    }
    return true;
}

function getLongitudeDirection(longitude){
    return longitude >=0 ? 'East' : 'West';
}

function getLatitudeDirection(latitude){
    return latitude >=0 ? 'North' : 'South';
}

function getHemisphere(longitude,latitude){
    return `${getLatitudeDirection(latitude)} & ${getLongitudeDirection(longitude)}`
}

function getDistance(x,y){
    return Math.sqrt(x*x*Math.pow(110.574,2) + y*y*Math.pow(111.321,2));
}

function analyzeIncome(yourcountry,othercountry,yours, other){
    const income = Array('low','middle','high');
    const degree = Array('lower','upper');
    var yourincome = {
        income : yours.length === 3 ? income.indexOf(yours[1].toLowerCase()) : income.indexOf(yours[0].toLowerCase()),
        degree : yours.length === 3 ? degree.indexOf(yours[0].toLowerCase()) : 1
    }
    var otherincome = {
        income : other.length === 3 ? income.indexOf(other[1].toLowerCase()) : income.indexOf(other[0].toLowerCase()),
        degree : other.length === 3 ? degree.indexOf(other[0].toLowerCase()) : 1
    }

    let decider = yourincome.income < otherincome.income ? 'worse' : 'better';
    if (yourincome.income != otherincome.income){
        return `${yourcountry} has ${decider} overall income than ${othercountry}`;
    }
    else{
        decider = yourincome.degree < otherincome.degree ? 'worse' : 'better';
        if(yourincome.degree === otherincome.degree)
            return `${yourcountry} has almost the same overall income as ${othercountry}`;
        else
            return`${yourcountry} has slightly ${decider} overall income than ${othercountry}`;
    }
}
function analyzeGeolocation(yourslongitude,yourslatitude,otherlongitude,otherlatitude){
    var res = {
        yourhemisphere : getHemisphere(yourslongitude,yourslatitude),
        otherhemisphere : getHemisphere(otherlongitude,otherlatitude),
        longitude : (otherlongitude - yourslongitude),
        latitude : (otherlatitude - yourslatitude),
        longitudedirection: '',
        latitudedirection: '',
        overall : 0
    }
    res.longitudedirection = getLongitudeDirection(res.longitude);
    res.latitudedirection = getLatitudeDirection(res.latitude);
    res.overall = getDistance(res.latitude,res.longitude);
    
    return res;
}

function analyzeData(yours,other,ip){
    //[1][0] to get detail info about country
    const firstinfo = yours[1][0];
    const secondinfo = other[1][0];
    var res = {
        countryNames : {
            yours : firstinfo.name,
            other : secondinfo.name
        },
        income :{
            yours : firstinfo.incomeLevel.value,
            other : secondinfo.incomeLevel.value,
            summary : analyzeIncome(firstinfo.name,secondinfo.name,firstinfo.incomeLevel.value.split(' '),secondinfo.incomeLevel.value.split(' '))
        },
        capitals: {
            yours : firstinfo.capitalCity,
            other : secondinfo.capitalCity
        },
        coordinates: {
            yourslongitude : firstinfo.longitude,
            yourslatitude : firstinfo.latitude,
            otherlongitude : secondinfo.longitude,
            otherlatitude : secondinfo.latitude
        },
        geographics: analyzeGeolocation(parseFloat(firstinfo.longitude),parseFloat(firstinfo.latitude),
        parseFloat(secondinfo.longitude),parseFloat(secondinfo.latitude)),
        IPAddressInformations : {
            address : ip.query,
            location : ip.country,
            city : ip.city,
            summary : ip.countryCode === firstinfo.iso2Code ? `Device with assigned IP located in ${firstinfo.name}` :
            (ip.countryCode === secondinfo.iso2Code ? `Device with assigned IP located in ${secondinfo.name}` : 
            `Device with given IP is located in other country. It is located in ${ip.country}`),
            ISP : ip.isp,
            organization : ip.org,
            ownlongitude : ip.lon,
            ownlatitude : ip.lat,
            longitudeToFirst : (firstinfo.longitude - ip.lon),
            longitudeToFirstDirection : '',
            latitudeToFirst : (firstinfo.latitude - ip.lat),
            latitudeToFirstDirection : '',
            distanceToFirst : 0,

            longitudeToSecond : (secondinfo.longitude - ip.lon),
            longitudeToSecondDirection : '',
            latitudeToSecond : (secondinfo.latitude - ip.lat),
            latitudeToSecondDirection : '',
            distanceToSecond : 0
        }
    };

    res.IPAddressInformations.longitudeToFirstDirection = getLongitudeDirection(res.IPAddressInformations.longitudeToFirst);
    res.IPAddressInformations.longitudeToSecondDirection = getLongitudeDirection(res.IPAddressInformations.longitudeToSecond);

    res.IPAddressInformations.latitudeToFirstDirection = getLatitudeDirection(res.IPAddressInformations.latitudeToFirst);
    res.IPAddressInformations.latitudeToSecondDirection = getLatitudeDirection(res.IPAddressInformations.latitudeToSecond);

    res.IPAddressInformations.distanceToFirst = getDistance(res.IPAddressInformations.latitudeToFirst,res.IPAddressInformations.longitudeToFirst);
    res.IPAddressInformations.distanceToSecond = getDistance(res.IPAddressInformations.latitudeToSecond,res.IPAddressInformations.longitudeToSecond);

    return res;
}

function createHTML(res){
    return `<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>JSON Test</title>
    </head>
    <body>
        <span style="white-space: pre-line"></span>
        <h3>Information about countries</h3>
        <p>
            Countries chosen for analysis:
        </p>
        <p>
            -> <strong>${res.countryNames.yours}</strong> (Capital: <strong>${res.capitals.yours}</strong>)<br>
            -> <strong>${res.countryNames.other}</strong> (Capital: <strong>${res.capitals.other}</strong>)
        </p>
        <h4>Analysis information</h4>
        <p>
            <strong>Summary about income: ${res.income.summary}</strong><br>
            
            Geographic informations for <strong>${res.countryNames.yours}:</strong><br>
            Latitude: <strong>${Number(res.coordinates.yourslatitude).toFixed(2)}
            <span>&#176;</span>${getLatitudeDirection(Number(res.coordinates.yourslatitude))[0]}</strong><br>
            Longitude: <strong>${Number(res.coordinates.yourslongitude).toFixed(2)}
            <span>&#176;</span>${getLongitudeDirection(Number(res.coordinates.yourslongitude))[0]}</strong><br>
            Hemispheres: <strong>${res.geographics.yourhemisphere}</strong><br><br>
            
            Geographic informations for <strong>${res.countryNames.other}:</strong><br>
            Latitude: <strong>${Math.abs(Number(res.coordinates.otherlatitude)).toFixed(2)}
            <span>&#176;</span>${getLatitudeDirection(Number(res.coordinates.otherlatitude))[0]}</strong><br>
            Longitude: <strong>${Math.abs(Number(res.coordinates.otherlongitude)).toFixed(2)}
            <span>&#176;</span>${getLongitudeDirection(Number(res.coordinates.yourslongitude))[0]}</strong><br>
            Hemispheres: <strong>${res.geographics.otherhemisphere}</strong><br>
            
            <br><strong>Summary about locations:</strong><br> <strong>${res.capitals.yours}</strong> is located in 
            <strong>${res.geographics.latitudedirection}-${res.geographics.longitudedirection}</strong> direction compared to <strong>${res.capitals.other}</strong>.
            Differences in latitude and longitude between cities are <strong>${Math.abs(Number(res.geographics.latitude)).toFixed(2)}<span>&#176;</span>
            ${getLatitudeDirection(Number(res.geographics.latitude))[0]}</strong>
            and <strong>${Math.abs(Number(res.geographics.longitude)).toFixed(2)}<span>&#176;</span>${getLongitudeDirection(Number(res.geographics.longitude))[0]}</strong>. 
            Distance from each other is equal around <strong>${Math.ceil(Number(res.geographics.overall))}</strong> km.
        </p>
        <h4><strong>IP information</strong></h4>
        <p>
            Given IP is <strong>${res.IPAddressInformations.address}</strong><br> 
            <strong>${res.IPAddressInformations.summary}</strong> in <strong>${res.IPAddressInformations.city}</strong> city<br>
            ISP for given IP is <strong>${res.IPAddressInformations.ISP}</strong><br>
            Organization managing given IP: <strong>${res.IPAddressInformations.organization}</strong><br>
            Geographic informations for device with assigned IP <strong>${res.IPAddressInformations.address}:</strong><br>
            Latitude: <strong>${Math.abs(res.IPAddressInformations.ownlatitude).toFixed(2)}<span>&#176;</span>${getLatitudeDirection(res.IPAddressInformations.ownlatitude)[0]}</strong><br>
            Longitude: <strong>${Math.abs(res.IPAddressInformations.ownlongitude).toFixed(2)}<span>&#176;</span>${getLongitudeDirection(res.IPAddressInformations.ownlongitude)[0]}</strong><br>
            
            <br><strong>Summary about location:</strong><br>
            
            Device is located in <strong>${res.IPAddressInformations.longitudeToFirstDirection}-${res.IPAddressInformations.latitudeToFirstDirection}</strong> 
            direction compared to <strong>${res.capitals.yours}</strong>.<br>
            Differences in latitude and longitude between cities are <strong>${Math.abs(res.IPAddressInformations.latitudeToFirst).toFixed(2)}<span>&#176;</span>
            ${getLatitudeDirection(res.IPAddressInformations.latitudeToFirst)[0]}</strong> and <strong>${Math.abs(res.IPAddressInformations.longitudeToFirst).toFixed(2)}<span>&#176;</span>${getLongitudeDirection(res.IPAddressInformations.longitudeToFirst)[0]}</strong>.
            Distance between them is equal <strong>${Math.ceil(Number(res.IPAddressInformations.distanceToFirst))}</strong> km.<br>
            
            Device is also located in <strong>${res.IPAddressInformations.longitudeToSecondDirection}-${res.IPAddressInformations.latitudeToSecondDirection}</strong> 
            direction compared to <strong>${res.capitals.other}</strong>.<br>
            Differences in latitude and longitude between cities are <strong>${Math.abs(res.IPAddressInformations.latitudeToSecond).toFixed(2)}<span>&#176;</span>
            ${getLatitudeDirection(res.IPAddressInformations.latitudeToSecond)[0]}</strong> and <strong>${Math.abs(res.IPAddressInformations.longitudeToSecond).toFixed(2)}<span>&#176;</span>${getLongitudeDirection(res.IPAddressInformations.longitudeToSecond)[0]}</strong>.
            Distance between them is equal <strong>${Math.ceil(Number(res.IPAddressInformations.distanceToSecond))}</strong> km.<br>
        </p>
        </body>
    </html>`
}
module.exports = {analyzeData,isEmptyObject,createHTML};