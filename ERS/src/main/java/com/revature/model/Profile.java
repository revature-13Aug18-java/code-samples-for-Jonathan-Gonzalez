package com.revature.model;

public class Profile {

	private int id;
	private String fname;
	private String lname;
	private String street;
	private String city;
	private String state;
	private int zipcode;
	private long phone;
	private String hireDate;
	private String birthDate;
	private String email;
	
	
	public Profile() {
		super();
	}


	public Profile(int id, String fname, String lname, String street, String city, String state, int zipcode, long phone,
			String hireDate, String birthDate, String email) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phone = phone;
		this.hireDate = hireDate;
		this.birthDate = birthDate;
		this.email = email;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getZipcode() {
		return zipcode;
	}


	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public String getHireDate() {
		return hireDate;
	}


	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((hireDate == null) ? 0 : hireDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + (int) (phone ^ (phone >>> 32));
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + zipcode;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (hireDate == null) {
			if (other.hireDate != null)
				return false;
		} else if (!hireDate.equals(other.hireDate))
			return false;
		if (id != other.id)
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		if (phone != other.phone)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zipcode != other.zipcode)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Profile [id=" + id + ", fname=" + fname + ", lname=" + lname + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", zipcode=" + zipcode + ", phone=" + phone + ", hireDate=" + hireDate
				+ ", birthDate=" + birthDate + ", email=" + email + "]";
	}
	
}
