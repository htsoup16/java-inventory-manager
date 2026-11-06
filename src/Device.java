//	Miriam Rose, mrose16, CIS 340, MP2

public class Device {

	private String sku;
	private String name;
	private boolean status;

	// getter for SKU
	public String getSKU() {
		
		return sku;	
	}
	
	// getter for name
	public String getName() {
			
		return name;	
	}
	
	// getter for status
	public boolean getStatus() {
			
		return status;	
	}
	
	// setter for device SKU
	public void setSKU(String sku) {
			
		this.sku = sku;
	}

	// setter for device name
	public void setName(String name) {
			
		this.name = name;
	}
	
	// setter for device status
	public void setStatus(boolean status) {
				
		this.status = status;
	}
	
}