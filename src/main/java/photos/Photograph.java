package photos;

/**
 * Represent a Photograph as a caption and filename
 */
public class Photograph {

    //TODO 2 add instance fields

    /**
     * Public constructor
     * @param theFileName local filename of the photograph
     * @param theCaption caption associated with the photo
     */
    public Photograph(String theFileName, String theCaption) {

        //TODO 2 complete the constructor
    }
    /**
     * getter for the caption
     * @return the caption
     */
    public String getCaption() {
        //TODO 2 replace this code
        return "";
    }

    /**
     * getter for the filename
     * @return the filename
     */
    public String getFilename() {

        //TODO 2 replace this code
        return "";
    }


    /**
     * Determine equality as having the same filename and caption
     * @param o another object to check for equivalence against this
     * @return true if o contains equivalent data as this
     */
    public boolean equals(Object o) {
        //complete this method
        //you are given some typical code that starts many equals methods

        //are the objects at the same memory location?
        if (o == this) {
            //if yes then we are done they are the same object
            return true;
        }
        //is the object null or is it something other than a Photograph?
        if (o == null || o.getClass() != this.getClass()) {
            //if null or not a photograph then return false (it can't be equal to this
            //since this isn't null and is a photograph
            return false;
        }

        //otherwise cast it to a photograph and determine equality
        Photograph photo = (Photograph) o;

        //TODO 2 your code here (replace the return false)
        return false;

    }

    /**
     * Convert the Photograph to a String by including the filename and caption
     * @return a String containing the filename and caption
     */
    public String toString() {
        //TODO 2 replace this code with your code
        return "";
    }



}
