package com.springcore.collections;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Emp {

	private String name;
	private List<String> phones;
	private Set<String> adddress;
	private Map<String, String> courses;
	private Properties props;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPhones() {
		return phones;
	}

	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

	public Set<String> getAdddress() {
		return adddress;
	}

	public void setAdddress(Set<String> adddress) {
		this.adddress = adddress;
	}

	public Map<String, String> getCourses() {
		return courses;
	}

	public Emp(String name, List<String> phones, Set<String> adddress, Map<String, String> courses, Properties props) {
		super();
		this.name = name;
		this.phones = phones;
		this.adddress = adddress;
		this.courses = courses;
		this.props = props;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	public void setCourses(Map<String, String> courses) {
		this.courses = courses;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Emp [name=" + name + ", phones=" + phones + ", adddress=" + adddress + ", courses=" + courses
				+ ", props=" + props + "]";
	}

}
