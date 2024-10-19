import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Cookie cookieOne = new Cookie("green");
        Cookie cookieTwo = new Cookie("blue");
        System.out.println(cookieOne.getColor());
        System.out.println(cookieTwo.getColor());
        cookieOne.setColor("yellow");
        System.out.println(cookieOne.getColor());


        //Map's store pointers to their data. Confirm that here
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        map1.put("value", 11);
        map2 = map1;

        map1.put("valueTwo", 22);
        System.out.println(map1);
        map1.put("value", 15);
        System.out.println(map2);

    }
}


