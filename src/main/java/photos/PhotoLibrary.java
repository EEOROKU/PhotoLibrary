package photos;

import java.util.ArrayList;
import photos.Photograph;

import static java.lang.Math.min;

/**
 * A Collection of Photos makes up a PhotoLibrary
 */
public class PhotoLibrary {

    //name of the photo library
    private String name;

    //a unique ID for the library
    private final int id;

    //All the photos in the library
    private ArrayList<Photograph> photos;

    /**
     * Public Constructor
     * @param name a string identifier for the library
     * @param id a unique id for the library
     */
    public PhotoLibrary(String name, int id) {
        this.name = name;
        this.id = id;
        photos = new ArrayList<>();
    }

    /**
     * Getter for the name field
     * @return name
     */
    public String getName () {
        return name;
    }

    /**
     * getter for the id field
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for the photos
     * @return the list of photos
     */
    public ArrayList<Photograph> getPhotos() {
        return photos;
    }

    /**
     * setter for name
     * @param name the new name for the photo library
     */
    public void setName(String name) {
        this.name = name;
    }



    /**
     * Determine equality between photolibraries
     * @param o the other library to compare against this
     * @return true if o and this have the same id
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() == this.getClass()) {
            PhotoLibrary library = (PhotoLibrary) o;
            if (library.getId() == this.id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Convert the photo library to a string
     * @return a string containing the pertinent details of the library
     */
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Name: ");
        buffer.append(name);
        buffer.append(" id: ");
        buffer.append(id);
        buffer.append(" Photos: \n");
        for(Photograph p : photos) {
            buffer.append(p);
            buffer.append("\n");
        }
        return buffer.toString();
    }


    //TODO 5 Complete the methods below here

    /**
     * How many photos in the library
     * @return the number of photos
     */
    public int numPhotographs() {
        //TODO 5 replace this code
        return 0;
    }

    /**
     * Add a photo to the library of photos
     * if the photo p is already in the library then nothing is added and false is returned.
     * Otherwise the photo is added to the library and true is returned
     * @param p the photo to add
     * @return false if the library already contains that photo and true otherwise
     */
    public boolean addPhoto(Photograph p) {
        //TODO 5 replace this code
        return false;
    }

    /**
     * Determine if p is in the library
     * @param p the photo to determine if it is already in the library or not
     * @return true if p is in the library and false o.w.
     */
    public boolean hasPhoto(Photograph p) {
        //TODO 5 replace this code
        return false;
    }

    /**
     * remove the photo p from the library.
     * @param p the photo to remove
     * @return true if successful, false if p is not in the library to begin with
     */
    public boolean erasePhoto(Photograph p) {
        //TODO 5 replace this code
        return false;
    }

    /**
     * Determine the photos that are in common between two photo libraries
     * @param a a photo library
     * @param b a photo library
     * @return a new photo library containing the common photos
     */
    public static ArrayList<Photograph> commonPhotos(PhotoLibrary a, PhotoLibrary b) {

        //TODO 5 replace this code
        return null;
    }

    /**
     * A metric giving the similarity between two photo libraries, a and b,  calculated as a real number between 0 and 1 such that
     * the metric is 0 if a and b have no photos in common, otherwise it is the count of common photos between a and b,
     * divided by the size of the smallest photo library between a and b.
     * @param a photolibrary
     * @param b photolibrary
     * @return the similarity metric
     */
    public static double similarity(PhotoLibrary a, PhotoLibrary b) {

        //TODO 5 replace this code
        return 0;
    }
}
