package com.org.beans;

import com.qmetry.qaf.automation.data.BaseFormDataBean;
import com.qmetry.qaf.automation.ui.annotations.UiElement;
import com.qmetry.qaf.automation.ui.annotations.UiElement.Type;
import com.qmetry.qaf.automation.util.Randomizer;
import com.qmetry.qaf.automation.util.RandomStringGenerator.RandomizerTypes;

public class FlightDataBean extends BaseFormDataBean{
	
	@Randomizer(length=10,type=RandomizerTypes.MIXED)
	@UiElement(fieldLoc="BookFlight.passengers.dd",fieldType=Type.selectbox)
	private String passengers;
	
	@Randomizer(length=10,type=RandomizerTypes.MIXED)
	@UiElement(fieldLoc="BookFlight.DeptFrom.dd",fieldType=Type.selectbox)
	private String DeptFrom;
	
	@Randomizer(length=10,type=RandomizerTypes.MIXED)
	@UiElement(fieldLoc="BookFlight.FromMonth.dd",fieldType=Type.selectbox)
	private String FromMonth;
	
	@Randomizer(length=10,type=RandomizerTypes.MIXED)
	@UiElement(fieldLoc="BookFlight.Fromday.dd",fieldType=Type.selectbox)
	private String Fromday;
	
	@Randomizer(length=10,type=RandomizerTypes.MIXED)
	@UiElement(fieldLoc="BookFlight.Arrive.dd",fieldType=Type.selectbox)
	private String Arrive;
	
	@Randomizer(length=10,type=RandomizerTypes.MIXED)
	@UiElement(fieldLoc="BookFlight.toMonth.dd",fieldType=Type.selectbox)
	private String toMonth;
	
	@Randomizer(length=10,type=RandomizerTypes.MIXED)
	@UiElement(fieldLoc="BookFlight.today.dd",fieldType=Type.selectbox)
	private String today;

}
