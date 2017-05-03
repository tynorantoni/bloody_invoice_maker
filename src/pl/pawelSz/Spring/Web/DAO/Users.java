package pl.pawelSz.Spring.Web.DAO;

public class Users {

private String username;
private String password;
private boolean enabled=false;
private String authority;

public Users(){
	
}
public Users(String username, String password, boolean enabled, String authority) {
	
	this.username = username;
	this.password = password;
	this.enabled = enabled;
	this.authority = authority;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}
public String getAuthority() {
	return authority;
}
public void setAuthority(String authority) {
	this.authority = authority;
}
@Override
public String toString() {
	return "Users [username=" + username + ", password=" + password + ", enabled=" + enabled + ", authority="
			+ authority + "]";
}
	


}
