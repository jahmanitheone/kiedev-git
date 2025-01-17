package com.csra.eligibility.domain.entity.member;

import java.util.Calendar;
import java.util.Date;

public class Member implements java.io.Serializable {
	private String firstName;
	private String lastName;
	private String fullName;
	private Date dob;
	private int age;
	private String incomeType;
	private double houseHoldIncome;

	public Member() {
	}

	public Member(String fname, String lname, Date dob) {
		init(fname, lname, dob);
	}

	private void init(String fname, String lname, Date dob) {
		this.firstName = fname;
		this.lastName = lname;
		this.dob = dob;

		setAge();
	}

	private void setAge() {
		Calendar cdob = Calendar.getInstance();
		setAgeFromDob(cdob);
	}

	private void setAgeFromDob(Calendar cdob) {
		Calendar today = Calendar.getInstance();
		cdob.setTime(dob);

		this.age = today.get(Calendar.YEAR) - cdob.get(Calendar.YEAR);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;

		Calendar cdob = Calendar.getInstance();
		cdob.setTime(dob);
		
		setAgeFromDob(cdob);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHouseHoldIncome() {
		return houseHoldIncome;
	}

	public void setHouseHoldIncome(double income) {
		this.houseHoldIncome = income;
	}

	public boolean isNewBorn() {
		if (age < 1)
			return true;

		return false;
	}

	public boolean isInfant() {
		if (age > 1 && age <= 5)
			return true;

		return false;
	}

	public boolean isYouth() {
		if (age > 5 && age <= 13)
			return true;

		return false;
	}

	public boolean isTeen() {
		if (age > 13 && age <= 18)
			return true;

		return false;
	}

	public boolean isAdult() {
		if (age > 18 && age <= 55)
			return true;

		return false;
	}

	public boolean isSenior() {
		if (age > 55)
			return true;

		return false;
	}

	public boolean isRetired() {
		if (age > 67)
			return true;

		return false;
	}

	public String getIncomeType() {
		return this.incomeType;
	}

	public void setIncomeType(String incomeType) {
		if (incomeType != null)
			incomeType = incomeType.trim();

		this.incomeType = incomeType;
	}

	@Override
	public String toString() {
		StringBuilder bld = new StringBuilder();

		bld.append("Member [");
		bld.append("firstName=" + firstName + ", lastName=" + lastName + ", fullName=" + fullName + ", dob=" + dob
				+ ", age=" + age + ", houseHoldIncome=" + houseHoldIncome);
		bld.append(", incomeType:" + incomeType);
		bld.append(", isNewBorn:" + isNewBorn());
		bld.append(", isInfant:" + isInfant());
		bld.append(", isYouth:" + isYouth());
		bld.append(", isTeen:" + isTeen());
		bld.append(", isAdult:" + isAdult());
		bld.append(", isSenior:" + isSenior());
		bld.append(", isRetired:" + isRetired());

		bld.append("]");

		return bld.toString();
	}

}
