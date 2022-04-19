
public class UserModel {
    private int id;
    private String name;
    private int age;
    Database database;
    public UserModel(){
        database =  new Database();
    }
    public UserModel(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
        this.database =  new Database();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int add(){
        return database.insertUser(this);
    }

    public int update(){
        return database.updateUser(this);
    }

    public int remove(){
        return database.deleteUser(this);
    }
}
