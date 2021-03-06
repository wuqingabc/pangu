package org.turing.pangu.engine;

import java.util.ArrayList;
import java.util.List;

import org.turing.pangu.service.BaseService;

public class EngineMng {
	private List<EngineListen> ltnList = new ArrayList<EngineListen>();
	private List<BaseService> servicesList = new ArrayList<BaseService>();
	private static EngineMng mInstance = new EngineMng();
	
 	public static EngineMng getInstance()
	{
		if(null == mInstance)
			mInstance = new EngineMng();
		return mInstance;
	}
	// 设置监听
	private void setListen(){
		ltnList.clear();
		ltnList.add(AppEngine.getInstance());
		ltnList.add(TaskEngine.getInstance());
		ltnList.add(DeviceEngine.getInstance());
		ltnList.add(PlatformEngine.getInstance());
		ltnList.add(VpnEngine.getInstance());
		ltnList.add(IpTrunkEngine.getInstance());
		ltnList.add(ComputerEngine.getInstance());
		ltnList.add(SimulatorEngine.getInstance());
		ltnList.add(PhoneNumberEngine.getInstance());
		ltnList.add(PhoneBrandEngine.getInstance());
		ltnList.add(ResolutionEngine.getInstance());
		ltnList.add(WifiMngEngine.getInstance());
		ltnList.add(CmnPayUserEngine.getInstance());
		ltnList.add(UserEngine.getInstance());
	}
	// 设置服务
	private void setService(){
		for(EngineListen lst:ltnList){
			lst.setService(servicesList);
		}
	}
	private void setInit(){
		for(EngineListen lst:ltnList){
			lst.init();
		}
	}
	
	public void initEngine(List<BaseService> list){
		this.servicesList = list;
		setListen();
		setService();
		setInit();
	}
	// 定时触发保存缓存数据至数据库中
	public void triggerUpdateDB(){
		for(EngineListen lst:ltnList){
			lst.upDate();
		}
	}
}
