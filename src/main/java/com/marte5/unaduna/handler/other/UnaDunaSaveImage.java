package com.marte5.unaduna.handler.other;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.googlecode.pngtastic.core.PngImage;
import com.googlecode.pngtastic.core.PngOptimizer;
import com.marte5.unaduna.model.objects.Esito;
import com.marte5.unaduna.utility.EsitoHelper;
import com.marte5.unaduna.utility.FunzioniUtils;

import requests.RichiestaOtherGenerica;
import responses.RispostaOtherGenerica;

public class UnaDunaSaveImage implements RequestHandler<RichiestaOtherGenerica, RispostaOtherGenerica> {
	
	public static final String IMAGE_TYPE_PNG = "png";
	
    @Override
    public RispostaOtherGenerica handleRequest(RichiestaOtherGenerica input, Context context) {
    	
    	String className = this.getClass().getName();
    	RispostaOtherGenerica risposta = new RispostaOtherGenerica();
		Esito esito = FunzioniUtils.getEsitoPositivo(className);
        String idImmagine = FunzioniUtils.getEntitaId();
        
        //logica per salvataggio file su S3
        String base64 = input.getBase64Image();
        
        //pulizia del base64
        String[] splitted = base64.split(",");
        if(splitted.length > 1) {
        		base64 = splitted[1];
        }
        String format = IMAGE_TYPE_PNG;
        String filename =  idImmagine + "_" + input.getFilename() + "." + format;
        
        //controlli sui dati ricevuti
        String bucketName = getBucketName();
        
        AmazonS3 client = null;
        
        try {
        		client = AmazonS3ClientBuilder.standard().withRegion(Regions.EU_CENTRAL_1).build();
		} catch (Exception e1) {
			esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_SALVA_IMMAGINE);
			esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_SALVA_IMMAGINE + filename);
			esito.setTrace(e1.getMessage());
			risposta.setEsito(esito);
			return risposta;
		}
        if(client != null) {
			
			//creo un file dal base64 ricevuto
			byte[] data = Base64.decodeBase64(base64);
			ByteArrayInputStream bis = new ByteArrayInputStream(data);
			File outputfile;
			try {
				outputfile = File.createTempFile("temp", "temp");
			} catch (IOException e1) {
				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_SALVA_IMMAGINE);
				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_SALVA_IMMAGINE + filename);
				esito.setTrace(e1.getMessage());
				risposta.setEsito(esito);
				return risposta;
			}
			
			try {				
				PngImage image = new PngImage(bis);
				bis.close();
				// optimize
				PngOptimizer optimizer = new PngOptimizer();
				PngImage optimizedImage = optimizer.optimize(image, true, new Integer(9));
				// export the optimized image to a new file
				ByteArrayOutputStream optimizedBytes = new ByteArrayOutputStream();
				optimizedImage.writeDataOutputStream(optimizedBytes);
				
				ByteArrayInputStream bais = new ByteArrayInputStream(optimizedBytes.toByteArray());
				optimizedBytes.close();
				BufferedImage imout = ImageIO.read(bais);
				
		        bais.close();
		        ImageIO.write(imout, format, outputfile);
		    } catch (IOException e) {
		    	esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_SALVATAGGIO);
				esito.setMessage(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_PROCEDURA_LAMBDA + " putImage ");
				esito.setTrace(e.getMessage());
				risposta.setEsito(esito);
				return risposta;
		    }catch(Exception e1){
		    	esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_SALVATAGGIO);
				esito.setMessage(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_PROCEDURA_LAMBDA + " putImage ");
				esito.setTrace(e1.getMessage());
				risposta.setEsito(esito);
				return risposta;
		    }
				
			//preparo la richiesta di put aggiungendo l'istruzione che rende pubblico il file
			PutObjectRequest request = new PutObjectRequest(bucketName, filename, outputfile);
			request.setCannedAcl(CannedAccessControlList.PublicRead);
			client.putObject(request);
        }
        risposta.setEsito(esito);
        risposta.setImageUrl(FunzioniUtils.AMAZON_S3_BASE_URL + bucketName + "/" + filename);
        return risposta;
    }

	private String getBucketName() {
		
		return "unaduna-images-bucket";
	}
}
