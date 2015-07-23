import java.util.Arrays;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 
public class Complie {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("Assembly-CSharp.dll");
            byte[] bytes = Files.readAllBytes(path);
            byte[] result = new byte[bytes.length];
 
            for (int i = 0; i < bytes.length; i++) {
                result[i] = (byte)((int)bytes[i] ^ 0x71);
            }
 
            path = Paths.get("Real.dll");
            Files.write(path, result);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}