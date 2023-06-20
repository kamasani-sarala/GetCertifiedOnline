package com.demo.sorting;

import java.util.Comparator;

import com.demo.entity.Exam;

public class SortingBasedOnDuration implements Comparator<Exam> {

	@Override
	public int compare(Exam o1, Exam o2) {
		// TODO Auto-generated method stub
		return o2.getDuration()- o1.getDuration();
	}
	

}
