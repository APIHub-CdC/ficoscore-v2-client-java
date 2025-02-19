package com.cdc.apihub.mx.FS.test;

import com.cdc.apihub.mx.FS.client.ApiException;
import com.cdc.apihub.mx.FS.client.ApiResponse;
import com.cdc.apihub.mx.FS.client.api.FSApi;
import com.cdc.apihub.mx.FS.client.ApiClient;
import com.cdc.apihub.mx.FS.client.interceptor.SignerInterceptor;
import com.cdc.apihub.mx.FS.client.model.*;


import okhttp3.OkHttpClient;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

public class ApiTest {

	private Logger logger = LoggerFactory.getLogger(ApiTest.class.getName());

    private final FSApi api = new FSApi();
	private ApiClient apiClient;



	private String xApiKey = "your_api_key";
	private String username = "your_username";
	private String password = "your_password";
	
	private String url = "https://services.circulodecredito.com.mx/v2/ficoscore";

	private SignerInterceptor interceptor;

	@Before()
	public void setUp() {
		this.apiClient = api.getApiClient();
		this.apiClient.setBasePath(url);
		OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
				.readTimeout(30, TimeUnit.SECONDS)
				.addInterceptor(new SignerInterceptor())
				.build();
		apiClient.setHttpClient(okHttpClient);
	}

    @Test
    public void getReporteTest() throws ApiException {
		
    	Integer estatusOK = 200;
		Integer estatusNoContent = 204;

        Peticion peticion = new Peticion();
        Domicilio domicilio = new Domicilio();

		peticion.setFolio("121212");

		Persona persona = new Persona();
		persona.setNombres("JUAN");
		persona.setApellidoPaterno("PRUEBA");
		persona.setApellidoMaterno("CUATRO");
		persona.setFechaNacimiento("1980-01-04");
		persona.setRFC("PUAC800107");

		domicilio.setDireccion("INSURGENTES SUR 1007");
		domicilio.setColoniaPoblacion("INSURGENTES SUR");
		domicilio.setDelegacionMunicipio("CIUDAD DE MEXICO");
		domicilio.setCiudad("CIUDAD DE MEXICO");
		domicilio.setEstado(CatalogoEstados.DF);
		domicilio.setCP("03920");
		persona.setDomicilio(domicilio);

		peticion.setPersona(persona);
        


		ResponseScore response = api.getGenericReporte(xApiKey, username, password, peticion);
		logger.info(response.toString());



	}

	@Test
	public void getReporteTestFolio() throws ApiException {
		RequestScoreFolio peticion = new RequestScoreFolio();
		peticion.setFolioConsulta("900000000001");
		peticion.setFolioOtorgante("240101000001");


		try {
			ResponseScore response = api.getGenericReporteFolio(xApiKey, username, password, peticion);

			Assert.assertTrue(response != null);
			if(response != null) {
				logger.info(response.toString());
			}
		} catch (ApiException e) {
			logger.info(e.getResponseBody());
		}
	}
}