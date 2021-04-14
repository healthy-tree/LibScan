package pri.kevin;

import com.google.common.io.Files;
import org.apache.tika.Tika;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class DirTools {

  public void scanDirs(String path) throws IOException {
    if (path == null || path.length() <= 0) {
      return;
    }
    File file = new File(path);
    scanDirs(file);
  }

  public void scanDirs(File file) throws IOException {
    if (!file.exists()) {
      return;
    }
    if (!file.canRead()) {
      return;
    }
    if (file.isDirectory()) {
      File[] files = file.listFiles();
      for (File file1 : files) {
        scanDirs(file1);
      }
    } else {
      String fileExtension = Files.getFileExtension(file.getName());

      if (fileExtension.equals("jar")){
        Tika tika = new Tika();
        String detect = tika.detect(file);
        System.out.println(detect);
        System.out.print(Files.getNameWithoutExtension(file.getName())+" ");
        System.out.println(fileExtension);
        JarFile jarFile = new JarFile(file);
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
          JarEntry jarEntry = entries.nextElement();
          jarEntry.isDirectory();

          String toString = jarEntry.toString();
//          System.out.println(toString);
        }
      }
    }
  }
}
