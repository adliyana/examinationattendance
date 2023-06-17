package my.edu.utem.ftmk.dad.examinationattendance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "device")
public class Device {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DeviceId")
	private int DeviceId;
	
	@Column(name="LocationNo")
	private String LocationNo;
	
	@Column(name="DeviceType")
	private String DeviceType;

	public int getDeviceId() {
		return DeviceId;
	}

	public void setDeviceId(int deviceId) {
		DeviceId = deviceId;
	}

	public String getLocationNo() {
		return LocationNo;
	}

	public void setLocationNo(String locationNo) {
		LocationNo = locationNo;
	}

	public String getDeviceType() {
		return DeviceType;
	}

	public void setDeviceType(String deviceType) {
		DeviceType = deviceType;
	}
	
	
	
	
}
