
public class IntegerArrayManipulatorTester{

	public static void main(String[] args)
    {
		int[] x = { -1, 2, 4, 2, 7, 8, 9  };
        
		IntegerArrayManipulator am = new IntegerArrayManipulator(x);

		// original array
		am.printArray();
		
		// test 1
		am.swapFirstAndLast();
		System.out.print("Swapping: ");
		am.printArray();
		am.resetValues();
		
		// test 2
		am.shiftRight();
		System.out.print("Shifting right: ");
		am.printArray();
		am.resetValues();

		// test 3
		am.replaceEven();
		System.out.print("Replacing even elements: ");
		am.printArray();
		am.resetValues();

		// test 4
		am.replaceMiddle();
		System.out.print("Replacing middle elements: ");
		am.printArray();
		am.resetValues();

		// test 5
		am.removeMiddle();
		System.out.print("Removing middle element(s): ");
		am.printArray();
		am.resetValues();

		// test 6
		am.moveEven();
		System.out.print("Moving even elements: ");
		am.printArray();
		am.resetValues();

		// test 7
		System.out.print("Second largest element: ");
		System.out.println(am.secondLargest());

		// test 8
		System.out.print("Is sorted in increasing order: ");
		System.out.println(am.sortedIncreasing());

		// test 9
		System.out.print("Has adjacent duplicates: ");
		System.out.println(am.adjacentDups());

		// test 10
		System.out.print("Contains duplicates: ");
		System.out.println(am.containsDups());

	}

}
