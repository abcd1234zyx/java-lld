// Online Java Compiler
// Use this editor to write, compile and run your Java code online'

public class Hello {
    public static void main(String[] args) {
        Admin ad = new Admin("My name");
        ad.getSystemControl().addServer(2,3);
        ad.getSystemControl().addServer(4,5);
        ad.getSystemControl().addServer(6,7);
        ad.getSystemControl().connectServer(2,4,ConnectionEnum.connectionType.TWO_WAY_CONNECTION);
        ad.getSystemControl().disconnectServers(2, 4);
        JsonMessage msg = new JsonMessage();
        ad.getSystemControl().singleMessageSend(2,4,msg);
        ad.getSystemControl().singleMessageSend(1,3,msg);
        ad.getSystemControl().remServer(4);
        ad.getSystemControl().singleMessageSend(2,4,msg);
    }
}