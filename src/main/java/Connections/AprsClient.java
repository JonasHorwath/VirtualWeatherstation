package Connections;

import Backend.DataParser;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class AprsClient implements Runnable {

    private List<String> data;
    private BufferedReader reader;

    @Override
    public void run() {

        data = new ArrayList<>();
        try {
            System.out.println(reader.readLine());

            String wxmsg;
            while((wxmsg = reader.readLine()) != null && !Thread.interrupted()) {
                if (DataParser.useRegex(wxmsg)) {
                    data.add(wxmsg);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void connect() throws IOException {

        Socket socket = new Socket("rotate.aprs2.net", 10152);

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        reader = new BufferedReader(new InputStreamReader(in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

        System.out.println(reader.readLine());

        writer.write("user HTLLE pass -1");
        writer.newLine();
        writer.flush();


    }

    public void readData() throws IOException {

        System.out.println(reader.readLine());

        String message;

        while((message = reader.readLine()) != null || !Thread.interrupted()) {
            if (DataParser.useRegex(message)) {
                data.add(message);
            }
        }

        reader.close();
    }

    public List<String> getData() {
        return data;
    }

}
