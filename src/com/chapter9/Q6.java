package com.chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/*
 * Compute buildings with sunset View. 

      Windows facing west.
      Any building which is to the east of building equal or greator height can not view.
      process buildings in East to West order.
      For a building to view sunset, any building added should be lesser than the current height. or remove the current building. 
      
      
      E                     W

If buildings are in decreasing order, all can view sunset. 
Put a building into stack only if the current is less than the building height. 
if current height is greator or equal to stack peek, remove the b from stack and till condition satisfies , then add current to stack. 

Suppose there is one building on the W which height is max. None of buildings will be able to view sunset. 
Seems o[n] . each building will be processed max thrice. once for adding the building. once for removing . once for comparing the height. 

Need stack . because need to know building height just inserted.

Now buildings are presented in W to east order. 


Any building getting added will be able to view sunset if it is greator than the one in the stack. else it can not see. 
No removing of the building from the stack. 
this is easier to implement.


 */
public class Q6 {

	public static void main(String [] args) {
		Building b0 = new Building(0, 10);
		Building b1 = new Building(1, 9);
		Building b2 = new Building(2, 8);
		Building b3 = new Building(3, 7);
		Building b4 = new Building(4, 6);
		Building b5 = new Building(5, 5);
		Building b6 = new Building(6, 4);
		Building b7 = new Building(7, 3);
		Building b8 = new Building(8, 2);
		Building b9 = new Building(9, 5);
		
		Q6 q = new Q6();
		
		List<Building> bList = Arrays.asList(b0, b1, b2, b3, b4, b5, b6, b7, b8, b9);
		
		LinkedList<Building> result = q.getSunsetViewBuildings(bList);

		
		
		for (Building b: result) { //
			System.out.print(b.index + ",");
		}
	}
	
	// b is from E to W.
	/*
	 * Using Stack. Add last and remove last is stack.
	 * (on other hand Addfrst and removelast or add last and removefirst is Queue )
	 */
	public LinkedList<Building> getSunsetViewBuildings(List<Building> bList) {
		LinkedList<Building> result = new LinkedList<>();
		for (Building b: bList) {
			if (result.isEmpty() || result.peekLast().height > b.height) {
				result.addLast(b);
				continue;
			}
			
			while (!result.isEmpty()) {
				result.removeLast();
				
				// current building must be added to the list.
				if (result.isEmpty() || result.peekLast().height > b.height) {
					result.addLast(b);
					break;
				}
			}
		}
		
		return result;
	}
	
}

class Building {
	int index;
	int height;
	
	Building(int index, int height) {
		this.index = index;
		this.height = height;
	}	
	
	
}
