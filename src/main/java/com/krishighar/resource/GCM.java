package com.krishighar.resource;

import com.krishighar.commons.ErrorMessages;
import com.krishighar.commons.ResponseJson;
import com.krishighar.dao.GcmInfoDao;
import com.krishighar.pojo.db.SubscriberInfoPojo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by julina on 10/8/14.
 */
@Path("gcm")
public class GCM {

    @Autowired
    GcmInfoDao gcmInfoDao;

    @PUT
    public Response GCMRegistration(String jsonString){
        JSONObject responseJson = ResponseJson.getResponse();
        if(jsonString == null) {
            responseJson.put(ResponseJson.MESSAGE, ErrorMessages.NULL_REQUEST.toString());
            responseJson.put(ResponseJson.ERROR_CODE, ErrorMessages.NULL_REQUEST.getValue());
            return Response.ok().entity(responseJson.toString()).build();
        }
        JSONObject requestJson = new JSONObject(jsonString);
        if(!requestJson.has("deviceId") && !requestJson.has("regId")){
            responseJson.put(ResponseJson.MESSAGE, ErrorMessages.INVALID_USERNAME.toString());
            responseJson.put(ResponseJson.ERROR_CODE, ErrorMessages.INVALID_USERNAME.getValue());
            return Response.ok().entity(responseJson.toString()).build();
        }
        String deviceId =  requestJson.getString("deviceId");
        String regId = requestJson.getString("regId");

        SubscriberInfoPojo result = gcmInfoDao.registerGCM(deviceId, regId);
        if(result == null) {
            responseJson.put(ResponseJson.ERROR, false);
            responseJson.put(ResponseJson.ERROR_CODE, 200);
            responseJson.put(ResponseJson.MESSAGE, "success");
        }
        else {
            responseJson.put(ResponseJson.ERROR_CODE, ErrorMessages.DB_INSERTION_FAILURE.getValue());
            responseJson.put(ResponseJson.MESSAGE, ErrorMessages.DB_INSERTION_FAILURE);
        }
        return Response.ok().entity(responseJson.toString()).build();
    }
}
