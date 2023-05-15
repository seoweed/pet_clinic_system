package kr.pet.mvc;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);

    // 전화번호를 입력받는 화면
    public String getPhoneNumber() {
        System.out.print("전화번호를 입력해주세요 : ");
        return scanner.nextLine();
    }

    // 신규고객 정보 입력 화면
    public Customer newCustomer() {
        System.out.println("신규 고객 정보를 입력하세요.");
        System.out.print("전화번호를 입력해주세요 : ");
        String phoneNumber = scanner.nextLine();
        System.out.print("소유주 이름을 입력해주세요 : ");
        String ownName = scanner.nextLine();
        System.out.print("동물 이름을 입력해주세요 : ");
        String petName = scanner.nextLine();
        System.out.print("주소를 입력해주세요 : ");
        String address = scanner.nextLine();
        System.out.print("동물 종류 입력해주세요 : ");
        String species = scanner.nextLine();
        System.out.print("출생년도(yyyy)를 입력해주세요 : ");
        int birthYear = scanner.nextInt();
        scanner.nextLine();

        return new Customer(phoneNumber, ownName, petName, address, species, birthYear);
    }
    // 진료 기록을 입력받는 화면
    public MedicalRecord getMedicalRecordInfo() {
        System.out.println("진료 기록을 입력해주세요");
        System.out.print("진료일을 입력하세요 : ");
        String date = scanner.nextLine();

        System.out.print("진료 내용을 입력하세요 : ");
        String content = scanner.nextLine();

        return new MedicalRecord(null, date, content);
    }

    // 진료 기록을 조회하여 출력
    public void printMedicalRecord(Customer customer) {
        List<MedicalRecord> records = customer.getMedicalRecodes();
        for (MedicalRecord record : records) {
            System.out.println("record.getDate() = " + record.getDate());
            System.out.println("record.getContent() = " + record.getContent());
            System.out.println("customer.getOwnerName() = " + customer.getOwnerName());
            System.out.println("customer.getPetName() = " + customer.getPetName());
            System.out.println("customer.getAddress = " + customer.getAddress());
            System.out.println("customer.getSpecies() = " + customer.getSpecies());
            System.out.println("customer.getBirthYear() = " + customer.getBirthYear());
        }
    }
    // 메세지 출력
    public void printMessage(String message) {
        System.out.println(message);
    }
}
