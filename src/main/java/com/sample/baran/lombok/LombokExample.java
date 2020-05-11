import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class LombokExample {
    public static void main(String[] args) {
        //Builder example
        MyPojo myPojo = MyPojo.builder().id(1).name("Baran").age(31).build();
        System.out.println("id "+myPojo.getId()+" name "+myPojo.getName()+ " age="+myPojo.getAge());
        System.out.println(myPojo.toString());


        //Constructor example
        MyPojo myPojoConstructor = new MyPojo(2,"Saurabh",33);
        System.out.println("id "+myPojoConstructor.getId()+" name "+myPojoConstructor.getName()+ " age="+myPojoConstructor.getAge());
        System.out.println(myPojoConstructor.toString());

    }
}
@Data
@AllArgsConstructor
@Builder
class MyPojo{
    private int id;
    private String name;
    private int age;
}
