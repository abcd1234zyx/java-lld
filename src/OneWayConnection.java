class oneWayConnection implements Connection{
     public boolean connect(Server server1, Server server2){
        try{
        server1.connectTo(server2);
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