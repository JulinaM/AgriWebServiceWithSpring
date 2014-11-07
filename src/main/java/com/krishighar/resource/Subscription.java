package com.krishighar.resource;

import com.krishighar.commons.AgriException;
import com.krishighar.commons.ErrorMessages;
import com.krishighar.commons.ResponseJson;
import com.krishighar.dao.SubscriberDao;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * Created by julina on 10/7/14.
 */
@Path("subscribe")
public class Subscription {

    @Autowired
    SubscriberDao subscriberDao;

    @PUT
    public Response getLocation(String jsonString){
        JSONObject responseJson = ResponseJson.getResponse();
        try {
            JSONObject requestJson = new JSONObject(jsonString);
            String deviceId = requestJson.getString("deviceId");
            String phoneNumber = requestJson.getString("phoneNumber");
            JSONArray tags = requestJson.getJSONArray("tags");
            subscriberDao.insert(deviceId,phoneNumber ,tags);
            responseJson.put(ResponseJson.ERROR, false);
            responseJson.put(ResponseJson.ERROR_CODE, 200);
            responseJson.put(ResponseJson.MESSAGE, "success");
            return Response.ok().entity(responseJson.toString()).build();
        } catch (SQLException e) {
            responseJson.put(ResponseJson.ERROR_CODE, ErrorMessages.INTERNAL_SERVER_ERROR.getValue());
            responseJson.put(ResponseJson.MESSAGE, e.getMessage());
            return Response.ok().entity(responseJson.toString()).build();
        } catch (AgriException.NullPointerException e) {
            responseJson.put(ResponseJson.ERROR_CODE, ErrorMessages.INTERNAL_SERVER_ERROR.getValue());
            responseJson.put(ResponseJson.MESSAGE, e.getMessage());
            return Response.ok().entity(responseJson.toString()).build();
        }
    }
}
