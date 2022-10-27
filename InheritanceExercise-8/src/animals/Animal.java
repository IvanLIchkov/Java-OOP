package animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    private void setName(String name) {
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name=name;
    }

    private void setAge(int age) {
        if (age<0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    private void setGender(String gender) {
        if (gender.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
    public String produceSound(){
        return "";
    }

    @Override
    public String toString() {
        StringBuilder output=new StringBuilder(String.format("%s%n",this.getClass().getSimpleName()));
        output.append(String.format("%s %d %s%n",this.name,this.age,this.gender));
        output.append(produceSound());
        return String.valueOf(output);
    }
}
