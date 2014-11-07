package com.krishighar.resource;

import com.krishighar.commons.ErrorMessages;
import com.krishighar.commons.ResponseJson;
import com.krishighar.dao.InfoDao;
import com.krishighar.pojo.db.InfoPojo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by julina on 10/9/14.
 */
@Path("info")
public class Info {
    @Autowired
    InfoDao infoDao;

    @GET
    @Path("{tag}/{timestamp}")
    public Response getCropsDetail(@PathParam("tag") String tag,@PathParam("timestamp") long infoTime){
        JSONObject responseJson = ResponseJson.getResponse();
            if(tag == null) {
                responseJson.put(ResponseJson.MESSAGE, ErrorMessages.NULL_REQUEST.toString()+"jsonString null");
                responseJson.put(ResponseJson.ERROR_CODE, ErrorMessages.NULL_REQUEST.getValue());
                return Response.ok().entity(responseJson.toString()).build();
            }
            List<InfoPojo> infoPojos = infoDao.getInfos(tag);
            JSONArray jsonArray = new JSONArray();
            for(InfoPojo infoPojo : infoPojos){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("title", infoPojo.getTitleEn());
                jsonObject.put("from", infoPojo.getInfoFrom());
                jsonObject.put("body", infoPojo.getDataEn());
                jsonObject.put("timestamp", infoPojo.getTimestamp());
                jsonArray.put(jsonObject);
            }
            responseJson.put(ResponseJson.ERROR, false);
            responseJson.put(ResponseJson.ERROR_CODE, 200);
            responseJson.put(ResponseJson.BODY, jsonArray);
            responseJson.put(ResponseJson.MESSAGE, "success");
        return Response.ok().entity(responseJson.toString()).build();
    }
}
