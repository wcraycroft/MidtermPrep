public class PolymorphicArray {

    public static void main (String[] args) {
        // Declare Movies array
        Movie[] movies = new Movie[4];
        // Populate array with Movie and its children
        movies[0] = new Movie("PG", "A12345", "Frozen");
        movies[1] = new Action();           // test default constructor
        movies[2] = new Comedy("PG-13", "C54321", "Meet the Parents");
        movies[3] = new Drama("R", "X32154", "Basic Instinct");
        // Loop through array
        for (int i = 0; i < movies.length; i++) {
            // test toString()
            System.out.println(movies[i].toString());
            // test calcLateFees
            System.out.println("Late fee = " + movies[i].calcLateFees(5));
        }
    }


    public class Movie {

        // Constants
        public static final double DEFAULT_LATE_FEE = 2.0;

        // Member variables
        private String mRating;
        private String mID;
        private String mTitle;

        // Default constructor
        public Movie() {
            mRating = "";
            mID = "";
            mTitle = "";
        }
        // Parameterized constructor
        public Movie(String rating, String id, String title) {
            mRating = rating;
            mID = id;
            mTitle = title;
        }

        // Getters
        public String getRating() {
            return mRating;
        }
        public String getID() {
            return mID;
        }
        public String getTitle() {
            return mTitle;
        }

        // Setters
        public void setRating(String rating) {
            mRating = rating;
        }
        public void setID(String id) {
            mID = id;
        }
        public void setTitle(String title) {
            mTitle = title;
        }

        // toString() - e.g., Movie[ID, Title, Rating]
        public String toString() {
            return "Movie[ID=" + mID + ", Title=" + mTitle + ", Rating=" + mRating + "]";
        }

        // equals() - checks for equal id's
        public boolean equals(Object anObject) {
            if ((anObject == null) || getClass() != anObject.getClass())
                return false;
            Movie otherMovie = (Movie) anObject;
            return (mID.equals(otherMovie.mID));
        }

        // Helper methods
        // calcLateFees() - takes input of number of days and returns the late fee
        public double calcLateFees(int numberOfDays) {
            if (numberOfDays > 0) {
                return numberOfDays * DEFAULT_LATE_FEE;
            } else {
                return 0.0;
            }
        }
    }


    public class Action extends Movie {

        // Constants
        public static final double ACTION_LATE_FEE = 3.0;

        // Default constructor
        public Action() {
            super();
        }
        // Parameterized constructor
        public Action(String rating, String id, String title) {
            super(rating, id, title);
        }

        // toString() - e.g., Action Movie[ID, Title, Rating]
        public String toString() {
            return "Action " + super.toString();
        }

        // Helper methods
        // calcLateFees() - takes input of number of days and returns the late fee
        public double calcLateFees(int numberOfDays) {
            if (numberOfDays > 0) {
                return numberOfDays * ACTION_LATE_FEE;
            } else {
                return 0.0;
            }
        }
    }


}
