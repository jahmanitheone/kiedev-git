package com.csra.eligibility.workflow.medicalincome;

import java.util.Calendar;

import com.csra.eligibility.domain.entity.member.Member;

/**
 * Test data while testing
 * 
 * @author pchauvet
 */
public class WFTestData {

	public static Member getSimpleMember() {
		Calendar date = Calendar.getInstance();
		date.add(Calendar.DAY_OF_MONTH, -120);
		Member mem = new Member("George", "Ralin", date.getTime());
		mem.setHouseHoldIncome(12000);

		return mem;
	}

	public static Member getNewBorn() {
		Calendar date = Calendar.getInstance();
		date.add(Calendar.DAY_OF_MONTH, -30);

		return new Member("Little", "Marcy", date.getTime());
	}

	public static Member getHouseHoldIncomeGreateThan50000() {
		Calendar date = Calendar.getInstance();
		date.add(Calendar.DAY_OF_MONTH, -30);

		Member mem = new Member("Tracy", "Lylu", date.getTime());
		mem.setHouseHoldIncome(55500);

		return mem;
	}

}
