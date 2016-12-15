package com.chapter14;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given is student array.
 * Each student has integer valued age feild that can be treated as key.
 * Rearrange array such that equal ages appear together.
 * The order in which different ages appear is not important.
 * 
 */
public class Q7 {

	public static void main(String[] args) {
		// 0 ,1, 5, 2, 3, 4 ,5, 1
		
		Student student1 = new Student("", 0);
		Student student2 = new Student("", 1);
		Student student3 = new Student("", 5);
		Student student4 = new Student("", 2);
		Student student5 = new Student("", 3);
		Student student6 = new Student("", 4);
		Student student7 = new Student("", 5);
		Student student8 = new Student("", 1);
		
		Student [] studentArray = {student1, student2, student3, student4, student5, student6, student7, student8};
		
		Q7 q = new Q7();
		q.rearrange(studentArray);
	}
	
	/*
	 * Rearrange array such that students of equal age appear together.
	 * Count the number of students of particular age. 
	 * Suppose age ranges from 0 to 100. Have count of students of particular age in the array
	 * Go through the array, record 
	 * 
	 * 
	 */
	public Student[] rearrange(Student [] studentList) {
		int [] ageCount = getAgeCount(studentList);
		
		/*
		 * for each student, based on the age , insert at the start index, incrementing the start index. 
		 */
		Student[] result = new Student[studentList.length];
		for (Student student: studentList) {
			result[ageCount[student.age]] =  student;
			ageCount[student.age]++;
		}
		
		/*
		 * now i know how many students of each age are present. 
		 * Go through the student array, put them in
		 */
		
		
		// check the result
		for(Student student : result) {
			System.out.print(student.age + ",");
		}
		return result;
		
	}
	
	int [] getAgeCount(Student [] studentList) {
		
		int [] ageCount = new int [100];
		
		for (Student student: studentList) {
			if (student.age >= 100 || student.age < 0) {
				// log and leave.
				continue;
			}
			ageCount[student.age]++;
		}
		
		/*
		 * get the start indices for each age.
		 *      0 ,1, 5, 2, 3, 4 ,5, 1
		 *     
		 *     1, 2, 1 ,1, 1, 2 => length is 8
		 *     
		 *     0, 1, 3, 4, 5, 7 => 
		 *     
		 *     Get the current Number of elements into temp object. 
		 *     update the current index to previous element start index + previous element count.
		 *     number of current elements will be saved as prevCount for the next element. 
		 *     
		 *     So in the last , sum of prev Count and last index will be length of array - 1
		 */
		
		int prevCount = ageCount[0];
		ageCount[0] = 0;
		
		for (int i = 1; i < ageCount.length; i++) {
			int currentCount = ageCount[i];
			ageCount[i] = prevCount + ageCount[i - 1];
			prevCount = currentCount;
		}
		return ageCount;
	}
	
	/*
	 * I have two maps.
	 * ageToCount => number of people of the particular age. 
	 * ageToIndexMap => the start index of person with age.
	 * 
	 * Get a start index and age from the ageToIndexMap. this is supposed to be. 
	 * Get the person at the startIndex. 
	 * 
	 */
	void getAgeIndexMap(List<Student> people) {
		Map<Integer, Integer> ageToCountMap = new HashMap<>();
		Map<Integer, Integer> ageToIndexMap = new HashMap<>();
		
		for (Student student: people) {
			ageToCountMap.put(student.age, ageToCountMap.get(student.age) != null ? ageToCountMap.get(student.age): 1);
		}
		
		int offset = 0;
		for (Map.Entry<Integer, Integer> entry: ageToCountMap.entrySet()) {
			ageToIndexMap.put(entry.getKey(), 0);
			offset += entry.getValue();
		}
		
		//ageToCountMap ==> key is age, value is number of students with that age
		//ageToIndexMap ==> key is age. value is start index.
		
		while (!ageToIndexMap.isEmpty()) {
			Map.Entry<Integer, Integer> current = ageToIndexMap.entrySet().iterator().next();
			
			Integer fromAge = current.getKey();
			Integer fromIndex = current.getValue();
			
			/*
			 * student at index fromIndex should have the age fromAge in the studentList.
			 * So index from  student list having fromAge, swap with the fromIndex student. 
			 * 
			 */
			Integer toAge = people.get(fromIndex).age;// age of the student currently at the index.
			Integer tovalue = ageToIndexMap.get(toAge);// index at where the student should be placed.
			
			
			Collections.swap(people, fromIndex, tovalue);
			Integer count = ageToCountMap.get(toAge) - 1;
			ageToCountMap.put(toAge,count);
			
			if (count > 0) {
				ageToIndexMap.put(toAge, tovalue + 1);
			} else {
				ageToCountMap.remove(toAge);
			}
		}
	}
	
	
	

}
