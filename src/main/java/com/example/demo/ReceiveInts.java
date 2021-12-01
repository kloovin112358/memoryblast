package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.Collections;

@Controller
public class ReceiveInts {

    public ArrayList<Integer> bubbleSort(ArrayList<Integer> mainList) {
		// have to make a copy to manipulate - otherwise the global one gets manipulated
		ArrayList<Integer> integerList = new ArrayList<Integer>(mainList);

		// temporary holder when swapping
		int tempVar;
		// we need to signal when we are done
		boolean sorted;
		
		for (int i = 0; i < integerList.size(); i++) {
			
			sorted = true;
			
			for (int j = 0; j < integerList.size() - 1; j++) {
				if (integerList.get(j) > integerList.get(j + 1)) {
					
					tempVar = integerList.get(j);
					integerList.set(j, integerList.get(j + 1));
					integerList.set(j + 1, tempVar);
					// since we had to do a swap, that we weren't done
					sorted = false;
				}
				
			}
			
			if (sorted) {
				break;
			}
			
		}
        return integerList;

	}

	@GetMapping("/game")
	public String receiveIntegers(@RequestParam ArrayList<Integer> ints, Model model) {

        // in a production application we would do a lot more cleaning of these
        // values, but for our simple implementation, we are just
        // going to assume that they are valid integers

        // we want to display the integers in order, so we will implement bubble sort here
        ArrayList<Integer> sortedInts = new ArrayList<Integer>(bubbleSort(ints));

        // now we are going to randomize the order of the integers,
        // because if they put in 1, 2, 3, 4, 5... or something similar,
        // it will be really easy to remember
        ArrayList<Integer> randomInts = new ArrayList<Integer>(sortedInts);
        Collections.shuffle(randomInts);

        model.addAttribute("sortedInts", sortedInts);
        model.addAttribute("randomInts", randomInts);

		return "ints";
	}

}