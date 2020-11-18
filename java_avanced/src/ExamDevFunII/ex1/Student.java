package ExamDevFunII.ex1;

public class Student {
    private String studentID;
    private String studentName;
    private String address;
    private String phone;

    public Student() {}
    public Student (String studentID, String studentName, String address, String phone) {
        super();
        this.studentID = studentID;
        this.studentName = studentName;
        this.address = address;
        this.phone = phone;
    }

    public String getStudentID() {
        return studentID;
    }
    public void setStudentID(String StudentID) {
        this.studentID = StudentID;
    }

    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String StudentName) {
        this.studentName = StudentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "Students{" +
                "student_ID=" + studentID +
                ", student_Name='" + studentName + '\'' +
                ", student_Address='" + address + '\'' +
                ", student_Phone='" + phone + '\'' +
                '}';
    }

}
