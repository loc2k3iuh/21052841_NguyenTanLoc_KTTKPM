package org.example.ex2;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Member member1 = new Member("Alice");
        Member member2 = new Member("Bob");

        // Tạo công việc và đăng ký thành viên theo dõi
        Task task = new Task("Develop Feature X");
        task.addObserver(member1);
        task.addObserver(member2);

        // Cập nhật trạng thái công việc, thông báo sẽ được gửi đến các thành viên
        task.setStatus("In Progress");
        task.setStatus("Completed");
        }
    }
