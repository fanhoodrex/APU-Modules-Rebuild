package Testing;

public class ValidationTest {
    public static void ValidUser(String username){
        String regex="^[A-Za-z][A-Za-z0-9]{7,14}$";
        System.out.println(username.matches(regex));
    }
    public static void main(String[] args){
        ValidUser("Abc12345");
        ValidUser("abc12345");
        ValidUser("12345abv");
        ValidUser("Abcdedfgh");
        ValidUser("ABCDEFGh");
        ValidUser("A_x1238583");
    }
}
