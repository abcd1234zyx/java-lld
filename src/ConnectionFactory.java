class ConnectionFactory {
    public Connection getConnectionType(ConnectionEnum.connectionType strat){
        if(strat == ConnectionEnum.connectionType.ONE_WAY_CONNECTION){
            return new oneWayConnection(); 
        }else if(strat == ConnectionEnum.connectionType.TWO_WAY_CONNECTION){
            return new twoWayConnection();
        }
        return null;
    }
}