
import java.util.Arrays;
import java.util.ArrayList;

public class IntegerArrayManipulator {

    // private instance variables
    private int[] values;
    // for resetting purposes, otherwise not needed
    private int[] originalValues; 

    // constructor
    public IntegerArrayManipulator(int[] initialValues) {
        values = initialValues;
        originalValues = Arrays.copyOf(values, values.length);
    }

    // printing for testing purposes
    public void printArray() {
        for (int i : values) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    // resetting back to original values for testing purposes
    public void resetValues() {
        values = Arrays.copyOf(originalValues, originalValues.length);
    }

    // swap the first and last elements
    public void swapFirstAndLast() {

        int temp = values[0];
        values[0] = values[values.length - 1];
        values[values.length - 1] = temp;

    }

    // shift all element to right and wraparound
    public void shiftRight() {
        
        int lastElement = values[values.length - 1];
        
        for (int i = values.length - 1; i > 0; i--){
            
            values[i] = values[i - 1];
            
        }
        
        values[0] = lastElement;

    }

    // replace even elements with zero
    public void replaceEven() {

        for (int i = 0; i < values.length; i++){
            
            if (values[i] % 2 == 0){
                
                values[i] = 0;
                
            }
            
        }

    }

    // replace middle elements with larger of two neighbors
    public void replaceMiddle() {
        
        int[] newArray = new int[values.length];
        
        newArray[0] = values[0];
        newArray[values.length - 1] = values[values.length - 1];
        
        for (int i = 1; i < values.length - 1; i++){
            
            if (values[i + 1] > values[i - 1]){
                
                newArray[i] = values[i + 1];
                
            }
            
            else{
                
                newArray[i] = values[i - 1];
                
            }
         
        }
        
        values = newArray;
                                 
    }
    
    // Private helper method that removes an element
    private void removeElement(int index){
        
        for (int i = index + 1; i < values.length; i++){
            
            values[i - 1] = values[i];

        }
        
        values = Arrays.copyOf(values, values.length - 1);
        
    }
    
    // Remove middle one or two elements
    public void removeMiddle() {

        if (values.length % 2 != 0){
            
            removeElement(values.length / 2); 
                
        }
        
        else{
            
            removeElement(values.length / 2);
            removeElement(values.length / 2);
            
        }

    }
    
    // Move even elements to the front
    public void moveEven() {

        int oddPointer = values.length - 1;
        
        while (oddPointer >= 0){
            
            int currentPointer = 1;
            
            while (currentPointer <= oddPointer){
                
                if (values[currentPointer] % 2 == 0 && 
                    values[currentPointer - 1] % 2 != 0){
                    
                    int temp = values[currentPointer - 1];
                    values[currentPointer - 1] = values[currentPointer];
                    values[currentPointer] = temp;
                    
                }
                
                currentPointer++;
                
            }
            
            oddPointer--;
        }

    }

    // Return second-largest element
    public int secondLargest() {

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for (int i = 0; i < values.length; i++){
            
            if (values[i] > largest){
                
                largest = values[i];
                
            }
            
        }
        
        for (int i = 0; i < values.length; i++){
            
            if (values[i] != largest && values[i] > secondLargest){
                
                secondLargest = values[i];
                
            }
            
        }
        
        if (secondLargest == Integer.MIN_VALUE){
            
            return largest;
            
        }  
        
        else{
            
            return secondLargest;
            
        }

    }

    // Check if sorted in increasing order
    public boolean sortedIncreasing() {

        boolean isSorted = true;
        
        for (int i = 1; i < values.length; i++){
            
            if (!(values[i] >= values[i - 1])){
                
                isSorted = false;
                
            }
            
        }
        
        return isSorted;

    }

    // Check if contains two adjacent duplicate elements
    public boolean adjacentDups() {

        boolean hasAdjacentDups = false;
        
        for (int i = 0; i < values.length - 1; i++){
            
            if (values[i] == values[i + 1]){
                
                hasAdjacentDups = true;
                
            }
            
        }
        
        return hasAdjacentDups;

    }

    // Check if contains any duplicate elements
    public boolean containsDups() {

        boolean hasDups = false;
        
        for (int i = 0; i < values.length; i++){
            
            for (int j = i + 1; j < values.length; j++){
                
                if (values[i] == values[j]){
                    
                    hasDups = true;
                    
                }
                
            }
            
        }
        
        return hasDups;

    }

}
