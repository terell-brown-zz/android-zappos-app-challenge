package ca.tbrown.ilovemarshmallow;

/**
 * Created by tmast_000 on 9/10/2015.
 */
public class Util {

    public static String resizeImageByURL(String url, String oldSize, String desiredSize) {
        // Changes segment of Image URL specifying size from oldSize to desiredSize
        if (url.contains(oldSize)) {
            return url.replace(oldSize, desiredSize);
        }
        return url;

    }
}
