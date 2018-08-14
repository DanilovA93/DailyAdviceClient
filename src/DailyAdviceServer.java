import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer { //первым делом запускаем сервер
    String[] adviceList = {"ешьте меньшими порциями","купите облегающие джинсы",
            "они не сделают тебя полнее","помни два слова: не годится","будьте честны хотябы сегодня"};

    public void go() {
        try {
            ServerSocket serverSock = new ServerSocket(4242);

            while(true) {
                Socket sock = serverSock.accept();

                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int)(Math.random()*adviceList.length);
        return adviceList[random];
    }

    public static void main (String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
