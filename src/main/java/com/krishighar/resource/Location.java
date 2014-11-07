package com.krishighar.resource;

import com.krishighar.commons.ResponseJson;
import com.krishighar.dao.LocationDao;
import com.krishighar.pojo.db.LocationPojo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by julina on 10/6/14.
 */
@Path("/location")
@Component
public class Location {

    @Autowired
    private LocationDao locationDao;

    @GET
    public Response getLocation(){
        JSONObject responseJson = ResponseJson.getResponse();
        List<LocationPojo> results = locationDao.getLocations();
        JSONArray jsonArray = new JSONArray();
        for(LocationPojo locationPojo : results){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", locationPojo.getLocationId());
            jsonObject.put("nameEn", locationPojo.getLocationNameEn());
            jsonObject.put("nameNp",locationPojo.getLocationNameNp());
            jsonArray.put(jsonObject);
        }
        responseJson.put(ResponseJson.ERROR, false);
        responseJson.put(ResponseJson.ERROR_CODE, 200);
        responseJson.put(ResponseJson.MESSAGE, "success");
        responseJson.put(ResponseJson.BODY, jsonArray);
        return Response.ok().entity(responseJson.toString()).build();
    }

}
