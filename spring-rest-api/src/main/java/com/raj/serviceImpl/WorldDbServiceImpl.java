package com.raj.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.beans.CountryBean;
import com.raj.dao.WorldDbDao;
import com.raj.service.WorldDbService;

@Service
public class WorldDbServiceImpl implements WorldDbService{
	
	@Autowired
	private WorldDbDao worldDbDao;
	private JSONObject responseJson = null;
	
	private static Logger logger = Logger.getLogger(WorldDbServiceImpl.class);
	
	/* (non-Javadoc)
	 * @see com.raj.service.WorldDbService#getAllCountry(java.lang.String)
	 */
	@Override
	public String getAllCountry(String requestData) {
		String status = "0";
		List<CountryBean> list = null;
		try {
			list = worldDbDao.getAllCountry();
			responseJson = new JSONObject();
			if(list.size() > 0){
				status = "1";
				responseJson.put("status",status);
				responseJson.put("countryList",list);
			}
			else{
				responseJson.put("status",status);
			}
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
			e.printStackTrace();
		}
		return responseJson.toString();
	}

}
