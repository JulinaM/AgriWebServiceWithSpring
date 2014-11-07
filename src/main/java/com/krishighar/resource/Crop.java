package com.krishighar.resource;

import com.krishighar.commons.ResponseJson;
import com.krishighar.dao.CropDao;
import com.krishighar.pojo.db.CropPojo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by julina on 10/7/14.
 */
@Path("crop")
public class Crop {

    @Autowired
    CropDao cropDao;

    @GET
    @Path("{location}")
    public Response getCrops(@PathParam("location") int locationId){
        JSONObject responseJson = ResponseJson.getResponse();
        List<CropPojo> results = null;
        if(locationId==0)
         results = cropDao.getCrops();
        else
         results = cropDao.getCropsForLocation(locationId);
        JSONArray jsonArray = new JSONArray();
        for(CropPojo crop : results){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", crop.getCropId());
            jsonObject.put("nameEn", crop.getCropNameEn());
            jsonObject.put("nameNp",crop.getCropNameNp());
            jsonObject.put("tag",locationId+"-"+crop.getCropId());
            jsonArray.put(jsonObject);
        }
        responseJson.put(ResponseJson.ERROR, false);
        responseJson.put(ResponseJson.ERROR_CODE, 200);
        responseJson.put(ResponseJson.MESSAGE, "success");
        responseJson.put(ResponseJson.BODY, jsonArray);
        return Response.ok().entity(responseJson.toString()).build();
    }
}
