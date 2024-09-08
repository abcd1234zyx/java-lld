class Admin{
    String name;
    ServerController cnt;
    public Admin(String name){
        this.name=name;
        cnt= new ServerController();
    }
    ServerController getSystemControl(){
        return cnt;
    }
    String getName() {
    	return name;
    }
}