package Constants;

import java.io.File;

public class FilesLocationForUsers {
    public static File dir1 = new File("/home/sfm/java_evaluation2/SeatReservation1/src/Files");
    public static final String USER_LOCATION = dir1.getPath() + "/user.txt";
    public static final String TRIP_FILE_PATH = dir1.getPath() + "/trips.txt";
}
