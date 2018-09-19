package com.marte5.unaduna.handler.utils;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;

import requests.UtilFunctionRequest;
import responses.UtilFunctionResponse;

public class UtilFunctionHandler implements RequestHandler<UtilFunctionRequest, UtilFunctionResponse> {

	private static String S3_PATH_DELIMITER = "/";

    @Override
    public UtilFunctionResponse handleRequest(UtilFunctionRequest request, Context context) {
    	
    		UtilFunctionResponse response = new UtilFunctionResponse();
    		
    		String prefisso = request.getPrefisso();
    		
    		String bucket = "unaduna-images-bucket";
    		AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();
    		
    		//richiedo sempre le directory
    		List<String> listaOggetti = listKeysInDirectory(bucket, prefisso, s3);
    		
    		response.setOggetti(new ArrayList<UtilFunctionResponse.Entita>());
    		
    		for(String oggetto:listaOggetti) {
    			if(!oggetto.contains("thumb") && !oggetto.contains("base_")) {
    				String nome = oggetto.split(S3_PATH_DELIMITER)[2];
    				UtilFunctionResponse.Entita acc = new UtilFunctionResponse.Entita();
        			acc.setNome(nome);
        			response.getOggetti().add(acc);
    			}
    		}
    		
    		return response;
    }
    
    public List<String> listKeysInDirectory(String bucketName, String prefix, AmazonS3 s3) {
        
	    	if (!prefix.endsWith(S3_PATH_DELIMITER)) {
		        prefix += S3_PATH_DELIMITER;
	    }
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
                .withBucketName(bucketName).withPrefix(prefix)
                .withDelimiter(S3_PATH_DELIMITER);
        ObjectListing objects = s3.listObjects(listObjectsRequest);
        List<String> elenco = objects.getCommonPrefixes();
        elenco.remove("BASE");//se è BASE non mi serve inserirlo nell'elenco che ritorno
        return elenco;
    }
}