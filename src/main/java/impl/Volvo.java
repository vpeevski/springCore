package impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import api.CarInterface;

@Component
public class Volvo implements CarInterface {
	
	private String model;
	
	private String marka;
	
	public Volvo (@Value("${model}") String model, @Value("${marka}") String marka) {
		this.model= model;
		this.marka=marka;
		
	}

	public String getMarka() {
		return marka;
	}

	public String getModel() {
		return model;
	}
	
	@Override
	public String toString() {
		return "Марка : Волво, модел : " + model ;
	}

	public void drive() {
		System.out.println("Drive drive drive ...");
		
	}

	public Integer driveTrip() {
		System.out.println("Drive a trip");
		return 5;
	}

}
