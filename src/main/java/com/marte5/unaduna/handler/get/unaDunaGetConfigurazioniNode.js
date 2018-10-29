var AWS = require("aws-sdk");

exports.handler = (event, context, callback) => {
    
    console.log(JSON.stringify(event, null, 2));
    var codiceUtente = event.codiceUtente;
//    AWS.config.update({
//    	  region: "us-west-2",
//    	  endpoint: "http://localhost:8000"
//    	});
	console.log("getConfigurazioni");
	var docClient = new AWS.DynamoDB.DocumentClient();

	var table = "UNADUNA_Configurazioni";
	

	var params = {
	    TableName: table
	};
	
	var response = {
		esito : "esito positivo",
		configurazioni : []
	}
	
	docClient.scan(params, function(err, data) {
	    if (err) {
	        console.error("Unable to read item. Error JSON:", JSON.stringify(err, null, 2));
	        callback(null, err); 
	    } else {
	    	var configurazioniFiltrate = [];
	    	for (var i = 0 ; i <  data.Items.length; i++){
	    		console.log(JSON.stringify(data.Items, null, 2));
	    		if(data.Items[i].utente.email == codiceUtente ) 
				configurazioniFiltrate.push(data.Items[i]);
	    	}
	    	response.configurazioni = configurazioniFiltrate;
	        callback(null, response); 
		 }
	});
}	