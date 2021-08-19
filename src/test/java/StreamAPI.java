import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {


    @Test
    public void test1() {
        List<String> list1 = new ArrayList<>() {{
            add("Hello world");
            add("Hello world !");
            add("Привет world !");
            add("Привет !");
        }};

        List<String> list = new ArrayList<>();
        list.add("Hello world");
        list.add("Hello world !");
        list.add("Привет world !");
        list.add("Привет !");

        List<String> newList = new ArrayList<>();
        for (String data : list) {
            if(data.contains("Hello")) {
                newList.add(data);
            }
        }
        System.out.println(newList);

        List<String> newList1 = new ArrayList<>(){{
            addAll(list.stream().filter(data -> data.contains("Hello")).collect(Collectors.toList()));
        }};

        System.out.println(newList1);
    }

}
