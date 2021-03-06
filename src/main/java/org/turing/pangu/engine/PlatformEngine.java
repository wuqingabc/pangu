package org.turing.pangu.engine;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.turing.pangu.model.Platform;
import org.turing.pangu.service.BaseService;
import org.turing.pangu.service.PlatformService;
import org.turing.pangu.service.PlatformServiceImpl;

public class PlatformEngine implements EngineListen{
	private static final Logger logger = Logger.getLogger(PlatformEngine.class);
	private static PlatformEngine mInstance = new PlatformEngine();
	private List<Platform> platformList = new ArrayList<Platform>();
	
	public static final long PLATFORM_XSD = 1; // 小神灯
	public static final long PLATFORM_YICHU = 2; // 移触
	public static final long PLATFORM_JUYOU = 3; // 聚优
	
	private PlatformService platformService;
	public static PlatformEngine getInstance()
	{
		if(null == mInstance)
			mInstance = new PlatformEngine();
		return mInstance;
	}
	
	public List<Platform> getPlatformListRealTime(){
		List<Platform> list = platformService.selectAll();
		return list;
	}
	
	public List<Platform> getPlatformList(){
		return platformList;
	}
	public Platform getPlatformInfo(Long id){
		for(Platform pf:platformList){
			if(pf.getId() == id ){
				return pf;
			}
		}
		return null;
	}
	@Override
	public void setService(List<BaseService> serviceList) {
		// TODO Auto-generated method stub
		for(BaseService service :serviceList){
			if(service instanceof PlatformServiceImpl ){
				this.platformService = (PlatformService)service;
			}
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		if(null != platformService){
			platformList.clear();
			platformList = platformService.selectAll();
		}
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upDate() {
		// TODO Auto-generated method stub
		
	}
}
