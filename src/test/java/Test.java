import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/5.
 */
public class Test {
    public static void main(String[] args)
    {
        Set<Student> set = new HashSet<Student>();
        Student s1 = new Student("Jack");
        Student s2 = new Student("Mary");
        Student s3 = new Student("Eason");

        set.add(s1);
        set.add(s2);
        set.add(s3);

        System.out.println(set.size());//3
        System.out.println(s2.hashCode());
        s2.setName("Jackson"); //修改属性，此时s2元素对应的hashcode值发生改变
        System.out.println(s2.hashCode());
        System.out.println(s2.getName());
        set.remove(s2);        // remove不掉，造成内存泄漏
        System.out.println(s2.hashCode());
        set.add(s2);           // 添加成功

        System.out.println(set.size());//4
    }
}
