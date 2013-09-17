import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.nio.file.StandardCopyOption.*;

public class updateFiles {
	public static void main(String[] args) {
		List<String> files = listFilesForFolder(new File(System.getProperty("user.dir")));
		List<String> folders = listFolders(new File(System.getProperty("user.dir")));
		for (String i : files) {
			if (!i.contains(".")) {
				for (String j : folders) {
					if (j.compareTo("disk") != 0) {
						try {
							Files.copy(Paths.get(i), Paths.get(j + "\\" + i), REPLACE_EXISTING);
						} catch (Exception e) {
							System.out.println(e);
						}
					}
				}
			}
		}
	}
	public static List<String> listFilesForFolder(final File folder) {
		List<String> returnVals = new ArrayList<String>();
	    for (final File fileEntry : folder.listFiles()) {
	        if (!fileEntry.isDirectory()) {
	            returnVals.add(fileEntry.getName());
	        }
	    }
	    return returnVals;
	}
	public static List<String> listFolders(final File folder) {
		List<String> returnVals = new ArrayList<String>();
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            returnVals.add(fileEntry.getName());
	        }
	    }
	    return returnVals;
	}
}