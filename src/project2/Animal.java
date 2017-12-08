package project2;

public class Animal {
    private String url;
    private String type;
    private String name;
    private String age;
    
    
    public Animal(String url, String type, String name, String age){
        this.url=url;
        this.type=type;
        this.name=name;
        this.age=age;
    }

    public String getUrl() {
        return url;
    }

    public String getType() {
        return type;
    }
    
    public String getName() {
        return name;
    }
    public String getAge() {
        return age;
    }
}
