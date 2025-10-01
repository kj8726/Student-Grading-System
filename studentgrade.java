// package StudentGrade;
import java.util.*;

class Student{
    String name;
    
    int mark1;
    int mark2;
    int mark3;

    public Student(String name,int a,int b,int c){
        this.name = name;
        this.mark1 = a;
        this.mark2 = b;
        this.mark3 = c;
    }

    void avermarks(){
        int averagmarks = (mark1+mark2+mark3)/3;
        System.out.println("the average marks is "+averagmarks+"\n\n");
    }    

    void percentageMark(){
        double percMarks = (mark1+mark2+mark3)*100/90;
        System.out.println("the percentage of student is : "+percMarks+"\n\n");
    }

    int getPercentage() {
    return (mark1 + mark2 + mark3) * 300 / 100;
    }

    String getGrade() {
        int perc = getPercentage();
        if(perc >= 90) return "A";
        else if(perc >= 80) return "B";
        else if(perc >= 70) return "C";
        else if(perc >= 60) return "D";
        else return "F";
    }

}

public class studentgrade {
    public static void main(String[] args) {
        HashMap<Integer,Student> ss = new HashMap<>();
        boolean istrue=true;
        int studentId = 100;
        Scanner sc = new Scanner(System.in);
        while(istrue){
            System.out.println("What do you want to do?");
            System.out.println("1)Create student");
            System.out.println("2)Find Average Marks");
            System.out.println("3)Find Percentage");
            System.out.println("4)Show all students");
            System.out.println("5)exit");

            int option = sc.nextInt();
            
            switch (option) {
                case 1:
                    sc.nextLine();
                    System.out.println("Enter name of Student");
                    String name = sc.nextLine();
                    System.out.println("Enter Marks of first sublect of student");
                    int mar1=sc.nextInt();
                    System.out.println("Enter Marks of second sublect of student");
                    int mar2=sc.nextInt();
                    System.out.println("Enter Marks of third sublect of student");
                    int mar3=sc.nextInt();

                    Student st = new Student(name, mar1, mar2, mar3);
                    ss.put(studentId, st);
                    System.out.println("Student Id created. Id : "+studentId+"\n");
                    studentId++;
                    break;
                
                case 2:
                    System.out.println("enter the id of student");
                    int idave = sc.nextInt();

                    if(ss.containsKey(idave)){
                        ss.get(idave).avermarks();
                    }else{
                        System.out.println("id not found");
                    }
                    break;

                case 3:
                    System.out.println("Enter id of Student");
                    int perId = sc.nextInt();
                    if(ss.containsKey(perId)){
                        ss.get(perId).percentageMark();
                    }else{
                        System.out.println("Id not Found");
                    }break;

                case 4:
                  
                    System.out.println("All students:");
                    for(Map.Entry<Integer, Student> entry : ss.entrySet()){
                    int id = entry.getKey();
                    Student s = entry.getValue();
                    System.out.println("ID: " + id + ", Name: " + s.name + ", Marks: " + s.mark1 + "," + s.mark2 + "," + s.mark3+", Grade is : "+s.getPercentage()+"% "+" Grade is : "+s.getGrade());
                    
                    }break;

                case 5:
                    System.out.println("thankyou for using our system");
                    istrue=false;
                    break;

                default:
                    System.out.println("Wrong option");
                    System.out.println("try again");
                    break;
                    
            }
        }
    }
}
