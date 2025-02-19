package com.cdc.apihub.mx.FS.client.api;

import com.cdc.apihub.mx.FS.client.ApiClient;
import com.cdc.apihub.mx.FS.client.ApiException;
import com.cdc.apihub.mx.FS.client.ApiResponse;
import com.cdc.apihub.mx.FS.client.Configuration;
import com.cdc.apihub.mx.FS.client.Pair;
import com.cdc.apihub.mx.FS.client.ProgressRequestBody;
import com.cdc.apihub.mx.FS.client.ProgressResponseBody;

import com.cdc.apihub.mx.FS.client.model.RequestScoreFolio;
import com.cdc.apihub.mx.FS.client.model.ResponseScore;
import com.google.gson.reflect.TypeToken;
import com.cdc.apihub.mx.FS.client.model.Peticion;
import com.cdc.apihub.mx.FS.client.model.Respuesta;

import java.io.IOException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FSApi {
    private ApiClient apiClient;
    public FSApi() {
        this(Configuration.getDefaultApiClient());
    }
    public FSApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    public ApiClient getApiClient() {
        return apiClient;
    }
    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    
    public okhttp3.Call ficoscoreCall(String xApiKey, String username, String password, Peticion request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        String localVarPath = "";
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xApiKey != null)
        localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
        if (username != null)
        localVarHeaderParams.put("username", apiClient.parameterToString(username));
        if (password != null)
        localVarHeaderParams.put("password", apiClient.parameterToString(password));
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);
        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }
        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    private okhttp3.Call ficoscoreValidateBeforeCall(String xApiKey, String username, String password, Peticion request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling pld(Async)");
        }
        if (username == null) {
            throw new ApiException("Missing the required parameter 'username' when calling pld(Async)");
        }
        if (password == null) {
            throw new ApiException("Missing the required parameter 'password' when calling pld(Async)");
        }
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pld(Async)");
        }
        
        okhttp3.Call call = ficoscoreCall(xApiKey, username, password, request, progressListener, progressRequestListener);
        return call;
    }
    
    public ResponseScore ficoscore(String xApiKey, String username, String password, Peticion request) throws ApiException {
        ApiResponse<ResponseScore> resp = ficoscoreWithHttpInfo(xApiKey, username, password, request);
        return resp.getData();
    }
    
    public ResponseScore getGenericReporte(String xApiKey, String username, String password, Peticion request) throws ApiException {
    	ApiResponse<ResponseScore> resp = ficoscoreWithHttpInfo(xApiKey, username, password, request);
        return resp.getData();
    }
    
    public ApiResponse<ResponseScore> ficoscoreWithHttpInfo(String xApiKey, String username, String password, Peticion request) throws ApiException {
        okhttp3.Call call = ficoscoreValidateBeforeCall(xApiKey, username, password, request, null, null);
        Type localVarReturnType = new TypeToken<ResponseScore>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }



    public ResponseScore getGenericReporteFolio(String xApiKey, String username, String password, RequestScoreFolio request) throws ApiException {
        ApiResponse<ResponseScore> resp = ficoscoreWithHttpInfoFolio(xApiKey, username, password, request);
        return resp.getData();
    }

    public ApiResponse<ResponseScore> ficoscoreWithHttpInfoFolio(String xApiKey, String username, String password, RequestScoreFolio request) throws ApiException {
        okhttp3.Call call = ficoscoreValidateBeforeCallFolio(xApiKey, username, password, request, null, null);
        Type localVarReturnType = new TypeToken<ResponseScore>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    private okhttp3.Call ficoscoreValidateBeforeCallFolio(String xApiKey, String username, String password, RequestScoreFolio request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling pld(Async)");
        }
        if (username == null) {
            throw new ApiException("Missing the required parameter 'username' when calling pld(Async)");
        }
        if (password == null) {
            throw new ApiException("Missing the required parameter 'password' when calling pld(Async)");
        }
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pld(Async)");
        }

        okhttp3.Call call = ficoscoreCallFolio(xApiKey, username, password, request, progressListener, progressRequestListener);
        return call;

    }
    public okhttp3.Call ficoscoreCallFolio(String xApiKey, String username, String password, RequestScoreFolio request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        String localVarPath = "/folio";
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xApiKey != null)
            localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
        if (username != null)
            localVarHeaderParams.put("username", apiClient.parameterToString(username));
        if (password != null)
            localVarHeaderParams.put("password", apiClient.parameterToString(password));
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);
        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                            .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                            .build();
                }
            });
        }
        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

}
