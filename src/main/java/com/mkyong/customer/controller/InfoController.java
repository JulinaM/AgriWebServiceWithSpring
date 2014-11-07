package com.mkyong.customer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;
import com.krishighar.dao.*;
import com.krishighar.pojo.db.GcmPublishPojo;
import com.krishighar.pojo.db.GcmPushMessagePojo;
import com.mkyong.customer.model.Info;
import com.mkyong.customer.validator.InfoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;


@Controller
@RequestMapping("/info")
public class InfoController {

    private static final String GOOGLE_SERVER_KEY = "AIzaSyAPxdy3kTeYeQQAo82saLCA1_k6WJriILc";
	InfoValidator infoValidator;

    @Autowired
    LocationDao locationDao;
    @Autowired
    CropDao cropDao;
	@Autowired
    InfoDao infoDao;
    @Autowired
    SubscriberDao subscriberDao;
    @Autowired
    GcmInfoDao gcmInfoDao;

	@Autowired
	public InfoController(InfoValidator infoValidator){
		this.infoValidator = infoValidator;
	}


	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(ModelMap model,
			@ModelAttribute("info") Info info,
			BindingResult result, SessionStatus status) {
		
		infoValidator.validate(info, result);
        if (result.hasErrors()) {
            //if validator failed
            info.setLocationPojoList(locationDao.getLocations());
            info.setCropPojos(cropDao.getCrops());
            model.addAttribute("info",info);
            return "InfoForm";
        }

        GcmPublishPojo gcmPublishPojo = infoDao.insertInfo(info);
        HashSet<String> deviceIds = subscriberDao.getSubscriberForTags(gcmPublishPojo.getTags());
        List<String> regIds = gcmInfoDao.getRegistrationIdsForDevices(deviceIds);
        gcmPublishPojo.setRegIds(regIds);
        GcmPushMessagePojo gcmPushMessagePojo = new GcmPushMessagePojo().initItems(gcmPublishPojo);
        ObjectMapper mapper = new ObjectMapper();
        try {
           String userMessage = mapper.writeValueAsString(gcmPushMessagePojo);
           Sender sender = new Sender(GOOGLE_SERVER_KEY);
           Message message = new Message.Builder().timeToLive(30)
                    .delayWhileIdle(true).addData("m", userMessage).build();
           MulticastResult multicastResult = sender.send(message, gcmPublishPojo.getRegIds(), 1);
            if(multicastResult.getSuccess()>0){
            // model.addAttribute("receiversCount",);
                return "UpdateSucess";
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        status.setComplete();
        //form success
        return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model){
		Info info = new Info();
        info.setLocationPojoList(locationDao.getLocations());
        info.setCropPojos(cropDao.getCrops());
		//command object
		model.addAttribute("info", info);

		//return form view
		return "InfoForm";
	}

	
}