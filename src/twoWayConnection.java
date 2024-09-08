class twoWayConnection implements Connection{
    public boolean connect(Server server1, Server server2){
        try{
        server1.connectTo(server2);
        server2.connectTo(server1);
        return true;
        }
        catch(Exception e){
            System.out.println("not able to connect"); 
            return false;
        }
        finally{
        }
    }
}