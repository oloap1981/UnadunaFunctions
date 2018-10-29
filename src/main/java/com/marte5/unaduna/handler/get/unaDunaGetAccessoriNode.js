var AWS = require("aws-sdk");

exports.handler = (event, context, callback) => {
    
    console.log(JSON.stringify(event, null, 2));
    var codiceModello = event.codiceModello;
//    AWS.config.update({
//    	  region: "us-west-2",
//    	  endpoint: "http://localhost:8000"
//    	});
	console.log("getAccessori");
	var docClient = new AWS.DynamoDB.DocumentClient();

	var table = "UNADUNA_Accessori";
	
	var params = {};
	console.log ("eccomi " +  codiceModello);
	if (codiceModello == undefined || codiceModello == ""){
		params = {
			    TableName: table
		};	
	}else{
		params = {
		    TableName: table,
		    FilterExpression: "modello = :val1",
		    ExpressionAttributeValues: {
		    	":val1": codiceModello
		    }
		};
	}
	
	var response = {
		esito : "esito positivo",
		configurazioni : []
	}
	
	docClient.scan(params, function(err, data) {
	    if (err) {
	        console.error("Unable to read item. Error JSON:", JSON.stringify(err, null, 2));
	        callback(null, err); 
	    } else {
	    	console.error("Unable to read item. Error JSON:", JSON.stringify(data, null, 2));
	    	response.accessori = data.data;
	    	response.esito.message = "esito positivo";
	        callback(null, response); 
		 }
	});
}	