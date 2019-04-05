public class BinarySearch {

    // Search algorithm at bottom

    public static final int SIZE_OF_ARRAY = 1000000 ;
    public static int levels = 0 ;                   // number of recursive calls used

    // Static variable to track how many levels it takes to complete the search
    public static void main(String[] args) {

        // Create an array of random numbers in sorted order
        double[] array = new double[SIZE_OF_ARRAY] ;
        array[0] = Math.random() ;
        for (int i = 1 ; i < array.length ; i++) {
            array[i] = array[i - 1] + Math.random() ;
        }

        // Using the binary search method, find the 77th element
        levels = 0 ;                     // number of recursive levels
        double searchKey = array[477] ;  // value to search for
        int found ;                      // return value from searching

        System.out.print("Looking for " + searchKey + "\n   ") ;
        if ((found = search(array, searchKey, 0, array.length - 1)) == -1) {
            System.out.print("Didn't find " + searchKey) ;
        } else {
            System.out.print("Found " + searchKey +
                    " at index " + found) ;
        }
        System.out.println(" in " + levels + " recursive calls") ;

        // Now try to find a value that isn't in the array
        levels = 0 ;
        searchKey = array[SIZE_OF_ARRAY - 1] + 1.0 ;
        System.out.print("\nLooking for " + searchKey + "\n   ") ;
        if ((found = search(array, searchKey, 0, array.length - 1)) == -1) {
            System.out.print("Didn't find " + searchKey) ;
        } else {
            System.out.print("Found " + searchKey +
                    " at index " + found) ;
        }
        System.out.println(" in " + levels + " recursive calls") ;
    }

    /************************************************************************
     * "search" algorithm taken from textbook.  Parameters include:
     *       1) An array of doubles to be searched
     *       2) the key (value) to search for
     *       3) the lowest index to search
     *       4) the highest index to search
     *
     * Returns the index (if the key is found) or -1 if the key is not found
     ************************************************************************/
    private static int search(double[] searchArray, double searchValue,
                              int lowIndex, int highIndex) {

        // Have we exhausted the search?  If so, we're done
        if (highIndex < lowIndex)
            return -1 ;

        // Increment the number of times we've called this method
        levels++ ;

        // Find the midpoint of lowIndex and highIndex.  See if that's it
        int midPoint = (lowIndex + highIndex) / 2 ;
        if (searchArray[midPoint] == searchValue) {
            return midPoint ;
        }

        // Didn't find it, so see which half the the array to search next
        if (searchValue < searchArray[midPoint]) {
            return search(searchArray, searchValue, lowIndex, midPoint - 1) ;
        }
        return search(searchArray, searchValue, midPoint + 1, highIndex) ;
    }
}