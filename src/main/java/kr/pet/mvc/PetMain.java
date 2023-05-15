package kr.pet.mvc;

import javax.swing.text.View;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class PetMain {
    public static void main(String[] args) {
        MedicalRecordController medicalRecord = new MedicalRecordController();
        CustomerController customer = new CustomerController(medicalRecord);
        ConsoleView view = new ConsoleView();
        while (true) {
            System.out.println("===애완동물 진료 관리 시스템===");
            System.out.println("1. 신규 고객 정보 입력");
            System.out.println("2. 진료 기록 저장");
            System.out.println("3. 진료 기록 조회");
            System.out.println("4. 진료 기록 삭제");
            System.out.println("5. 종료");
            System.out.print("원하시는 기능을 선택해주세요 : ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Customer newCustomer = view.newCustomer();
                    String phoneNumber = newCustomer.getPhoneNumber();
                    if (customer.isPhoneNumberExist(phoneNumber)) {
                        view.printMessage("이미 등록된 전화번호입니다.");
                        continue;
                    }
                    customer.addCustomer(newCustomer);
                    view.printMessage("고객 정보가 추가되었습니다.");
                    break;
                case 2: // 진료기록 저장
                    phoneNumber = view.getPhoneNumber();
                    if (customer.findCustomers(phoneNumber) == null) {
                        view.printMessage("해당 전화번호를 가진 고객 정보가 없습니다.");
                        break;
                    }
                    Customer cus = customer.findCustomers(phoneNumber);
                    MedicalRecord newRecord = view.getMedicalRecordInfo();
                    newRecord.setPhoneNumber(phoneNumber);
                    medicalRecord.addMedicalRecord(newRecord);
                    cus.addMedicalRecodes(newRecord);
                    view.printMessage("진료기록이 저장되었습니다.");
                    break;
                case 3: // 진료 기록 조회
                    phoneNumber = view.getPhoneNumber();
                    List<MedicalRecord> records = medicalRecord.findMedicalRecord(phoneNumber);
                    if (records.isEmpty()) {
                        view.printMessage("해당 전화번호를 가진 진료 기록이 없습니다.");
                        break;
                    }
                    cus = customer.findCustomers(phoneNumber);
                    view.printMedicalRecord(cus);
                    break;

                case 4: // 진료 기록 삭제
                    phoneNumber = view.getPhoneNumber();
                    if (customer.findCustomers(phoneNumber) == null) {
                        view.printMessage("해당 전화번호를 가진 고객 정보가 없습니다");
                        break;
                    }
                    medicalRecord.removeMedicalRecord(phoneNumber);
                    view.printMessage("진료 기록이 삭제되었습니다.");
                    break;
                case 5: // 종료
                    view.printMessage("종료되었습니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다.");
                    break;

            }

        }

    }

}
