import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;
import java.util.zip.InflaterInputStream;

public class AprsClient {

    public static void getData() throws IOException {

        Socket socket = new Socket("rotate.aprs2.net", 101552);
        Scanner mySc = new Scanner(new BufferedReader(new InputStreamReader(socket.getInputStream())));

        while (mySc.hasNextLine()) {
            if (Parser.useRegex(mySc.nextLine())) {



            }

        }

    }




}
