package annotation;

import lombok.ToString;

/**
 * @author ：wupeng
 * @date ：Created in 10:32 2019/1/10
 * @description：
 */
@ToString
public class User {
    @NotNull
    private String name;
    @NotNull
    private String age;

    @Init(value = "jude")
    @Validate(min=2,max=9)
    public void setName(String name) {
        this.name = name;
    }

    @Init(value = "25")
    @Validate(isNotNull = false)
    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
