package org.usfirst.frc.team871.robot;

import java.util.ArrayList;
import java.util.HashMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;

public class ButtJoystick extends Joystick{

	HashMap<Axes, ArrayList<Filter>> m_axesFilters = new HashMap<ButtJoystick.Axes, ArrayList<Filter>>();
	
	double m_measuredBefore = 0;
	double m_highPassOutput = 0;
	double m_output         = 0;
	
	public enum Axes{
		
		LEFTx(0),
		LEFTy(1),
		lTRIGGER(2),
		rTRIGGER(3),
		RIGHTx(4),
		RIGHTy(5);
		
		
		
		private final int axisNum;
		
		Axes(int axis){
			axisNum = axis;
		}
		
		
		public int getAxisNum(){
			return axisNum;
		}
	}
	
	
	public enum Buttons{
		
		A(1),
		B(2),
		X(3),
		Y(4),
		LB(5),
		RB(6),
		BACK(7),
		START(8);
		
		private final int buttonNum;
		
		Buttons(int button){
			buttonNum = button;
		}
		
		
		public int getButtonNum(){
			return buttonNum;
		}
	}
	

	public ButtJoystick(int port) {
		super(port);
	}

	boolean[] lastButtonValues = new boolean[8];

	
	
	
	
	
	
	public boolean justChanged(Buttons buttonName){
		int button = buttonName.getButtonNum();
		
		boolean justChanged = false;
		
		if (lastButtonValues[button] != getRawButton(button)){
			justChanged = true;
		}
		lastButtonValues[button] = getRawButton(button);
		
		return justChanged;
	}
	
	
	public boolean justPressed(Buttons buttonName){
		int button = buttonName.getButtonNum();
		
		boolean justPressed = false;
		
		if ((lastButtonValues[button] != getRawButton(button)) && getRawButton(button) == true){
			justPressed = true;
		}
		lastButtonValues[button] = getRawButton(button);//store values
		
		return justPressed;
	}
	
	public boolean justReleased(Buttons buttonName){
		int button = buttonName.getButtonNum();
		
		boolean justReleased = false;
		
		if ((lastButtonValues[button] != getRawButton(button)) && getRawButton(button) == false){
			justReleased = true;
		}
		lastButtonValues[button] = getRawButton(button);//store values
		
		return justReleased;
	}
	
	public boolean toggleButton(Buttons buttonName){
		
		int button = buttonName.getButtonNum();
		
		boolean toggle = false;
		
		if ((lastButtonValues[button] != getRawButton(button)) && getRawButton(button) == false){
			toggle = !toggle;
		}
		lastButtonValues[button] = getRawButton(button);//store values
		
		return toggle;
	}
	
	
	
	public void addFilter(Filter filter, Axes axis){
		
		if (m_axesFilters.containsKey(axis)){
			ArrayList<Filter> filtersApplied = m_axesFilters.get(axis);
			filtersApplied.add(filter);
		}else{
			ArrayList<Filter> firstFilter = new ArrayList<Filter>();
			firstFilter.add(filter);
			
			m_axesFilters.put(axis, firstFilter);
		}
		
	}
	

	public double getFilteredAxisValue(Axes axis){
		ArrayList<Filter> filtersApplied = m_axesFilters.get(axis);
		
		double axisVal = getAxisValue(axis);
		
		for(Filter f: filtersApplied){
			axisVal = f.update(axisVal);
		}
		
		return axisVal;
	}
	
	
	public double getAxisValue(Axes axis){
		return getRawAxis(axis.getAxisNum());
	}
	
	
}








