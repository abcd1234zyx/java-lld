import java.util.HashMap;

class Server{
    int serverId;
    int maxLimit;
    int numOfConn;
    HashMap<Integer,Server>arr;
    public Server(int serverId,int maxLimit){
        this.serverId=serverId;
        this.maxLimit=maxLimit;
        numOfConn=0;
        arr=new HashMap<Integer,Server>();
    }
    boolean checkLimit(){
        if(numOfConn == maxLimit){
            return false;
        }
        return true;
    }
    int getServerId(){
        return this.serverId;
    }
    int getMaxNumOfConnection(){
        return this.maxLimit;
    }
    void connectTo(Server server){
        arr.put(server.getServerId(),server);
        System.out.println(this.serverId+ "connected to server" + server.getServerId());
        numOfConn++;
    }
    void disconnectFrom(Server server){
        arr.remove(server.getServerId());
        numOfConn--;
    }
    boolean checkConnectionToServer(Server s2){
        if (arr.containsKey(s2.getServerId())== true){
            return true;
        }
        return false;
    }
    void sendMessage(Server server,Message m){
    	m.decode();
        System.out.println("sent message to" + server.getServerId());
    }
}