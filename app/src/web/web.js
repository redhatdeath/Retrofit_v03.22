const express = require('express');
const sqlite3 = require('sqlite3').verbose();
const sqliteJson = require('sqlite-json');

let app = express();

let db = new sqlite3.Database(
	'./db/gnusmas.db',
	sqlite3.OPEN_READWRITE,
	(err)=>	{
		if(err)	return console.error(err.message);		
		//console.log("Connected to the gnusmas.db SQLite database in READWRITE ");
	}
);

let exporter = sqliteJson(db);

app.listen(
	8081,
	function(){	console.log("Server is started at 8081"); } );

app.get( "/",
    function(req,res){ res.end("There is no data..."); } );

app.post( "/all",
	function(req,res){ workSelectAll().then( result => { res.end(result); } );	} );

async function workSelectAll(){
	return await selectAll();
}

function selectAll(){
	return new Promise(
		(resolve, reject) => {
			exporter.json( 'select * FROM Test' ,
				function (err, json) {
					if(err) { reject(err.message); }
					resolve(json);
				}
			);
		}
	);
}


// создаем парсер для данных application/x-www-form-urlencoded
let urlencodedParser = express.urlencoded({extended: true});

app.post(
	"/request",
	urlencodedParser,
	function(req,res){
		if(!req.body) res.sendStatus(400);
		console.log(req.body.toString());
		workSelectMarkFromTo(parseBody(req.body))
            .then( result => { res.end(result); } )
            .catch();
	}
);

function parseBody(body){
    let min = -1;
    let max = 11;
    if( body.mark_min ){ min = body.mark_min; }
    else { min = 0; }
    if( body.mark_max ){ max = body.mark_max; }
    else { max = 10; }
    return ' Select * FROM Test Where Mark >= '+min+' And Mark <='+max ;
}

async function workSelectMarkFromTo(sqlite_request){
	return await selectMarkFromTo(sqlite_request);
}

function selectMarkFromTo(sqlite_request){
    return new Promise(
		(resolve, reject) => {
			exporter.json(
			    sqlite_request,
				function (err, json) {
					if(err) { reject(err.message); }
					resolve(json);
				}
			);
		}
	);
}