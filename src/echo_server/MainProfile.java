package echo_server;

import java.util.ArrayList;
import java.util.List;

public class MainProfile {
	private String Id;
	private String Name;
	private boolean IsMainProfile;
	private boolean Locked;
	private String Username;
	private List<ContactPerson> ContactPerson;
	public MainProfile() {
		this.ContactPerson=new ArrayList<ContactPerson>();
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public boolean isIsMainProfile() {
		return IsMainProfile;
	}
	public void setIsMainProfile(String isMainProfile) {
		if ( isMainProfile.equals("true"))  IsMainProfile=true;
			else  IsMainProfile=false;
	}
	public boolean isLocked() {
		return Locked;
	}
	public void setLocked(String locked) {
		if (locked.equals("true")) Locked=true;
		else Locked=false;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public List<ContactPerson> getContactPerson() {
		return ContactPerson;
	}
	public void setContactPerson(ContactPerson contactPerson) {
		ContactPerson.add(contactPerson);
	}
	public void All(){
		   System.out.println(Username+"-"+IsMainProfile+"-"+Locked+"-"+Id+"-"+Name);
	   }
	
	
}
