public enum Qualidade {
    _240p, _360p, _720p, _1024p;

    public String toString(){
        return this.name().substring(1);
    }
    
}
