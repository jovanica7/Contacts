package adressBook;

import org.springframework.stereotype.Component;

@Component
public class RelationsInfo {
	
	private String first_name;
	private String last_name;
	private String type;
	
	public RelationsInfo(String f, String l, String t){
		this.first_name = f;
		this.last_name = l;
		this.type = t;
	}
	
	 public String getFirst_name() {
	        return first_name;
	 }

	 public void setFirst_name(String f) {
	        this.first_name = f;
	 }
	 
	 public String getLast_name() {
	        return last_name;
	 }

	 public void setLast_name(String l) {
	        this.last_name = l;
	 }
	 
	 public String getType() {
	        return type;
	 }

	 public void setType(String t) {
	        this.type = t;
	 }
	 
	 @Override
	 public String toString() {
		 return "RelationsInfo{" +
	                "first_name='" + first_name + '\'' +
	                ", last_name='" + last_name + '\'' +
	                ", type='" + type + '\'' + '}';
	                
	   }
	    

}
