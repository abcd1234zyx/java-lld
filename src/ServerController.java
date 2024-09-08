import java.util.ArrayList;
import java.util.HashMap;

class ServerController{
    HashMap<Integer,Server> arr;
    public ServerController(){
        arr = new HashMap<Integer,Server>();
    }
    void remServer(int server){
        arr.remove(server);
    }
    void addServer(int serverId,int maxConnection){
        arr.put(serverId, new Server(serverId,maxConnection));
    }
    Server findServerById(int serverId){
        return arr.get(serverId);
    }
    boolean connectServer(int serverId1, int serverId2,ConnectionEnum.connectionType conStrat){
        Server server1 = findServerById(serverId1);
        Server server2 = findServerById(serverId2);
        if(!server1.checkLimit()  ||  !server2.checkLimit())
        {
            return false;
        }
        ConnectionFactory ft = new ConnectionFactory();
        Connection conn = ft.getConnectionType(conStrat);
        return conn.connect(server1,server2);
    }
    boolean disconnectServers(int serverId1, int serverId2){
    	if(initialCheckBeforeSend(serverId1,serverId2) == false) {
    		return false;
    	}
         Server server1 = findServerById( serverId1);
        Server server2 = findServerById(serverId2);
        System.out.println("here");
        if(!server1.checkConnectionToServer(server2) || !server2.checkConnectionToServer(server1))
        {
            return false;
        }
        server1.disconnectFrom(server2);
        server2.disconnectFrom(server1);
        return true;
    }
    boolean checkConnection(int serverId1, int serverId2,int strat){
        Server server1 = findServerById( serverId1);
        Server server2 = findServerById( serverId2);
        return server1.checkConnectionToServer(server2) && server1.checkConnectionToServer(server2);
    }
    void broadCast(int serverId,Message m){
        Server server1 = findServerById(serverId);
        for(Server server : arr.values()){
        	if(initialCheckBeforeSend(serverId,server.getServerId()) == false) {
        		continue;
        	}
            server1.sendMessage(server,m);
        }
    }
    boolean initialCheckBeforeSend(int serverId1,int serverId2) {
    	Server s1 = findServerById(serverId1);
    	Server s2 = findServerById(serverId2);
    	if(s1 == null || s2 == null) {
    		System.out.println("server dont exsist");
    		return false;
    	}
    	if(s1.checkConnectionToServer(s2) == false) {
    		System.out.println("servers not connected");
    		return false;
    	}
    	return true;
    }
    void multiCast(int serverId,ArrayList<Integer>arrayServerId,Message m){
        Server server1 = findServerById(serverId);
        for(Integer recServerId : arrayServerId) {
        	if(initialCheckBeforeSend(serverId,recServerId) == false) {
        		continue;
        	}
            server1.sendMessage(findServerById(recServerId),m);
        }
    }
    void singleMessageSend(int serverId1, int serverId2,Message m){
    	if(initialCheckBeforeSend(serverId1,serverId2) == false) {
    		return;
    	}
         Server server1 = findServerById( serverId1);
         Server server2 = findServerById( serverId2);
        server1.sendMessage(server2,m);
    }
}