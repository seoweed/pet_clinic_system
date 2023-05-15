package kr.pet.mvc;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    private List<Customer> customers;
    private MedicalRecordController recordController;

    public CustomerController(MedicalRecordController recordController) {
        this.customers = new ArrayList<>();
        this.recordController = recordController;
    }
    // 고객 정보를 등록
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // 고객 정보 삭제 (진료기록도 함께 삭제 되어야 함)
    public void removeCustomer(String phoneNumber) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getPhoneNumber().equals(phoneNumber)) {
                // 고객 정보 삭제
                customers.remove(i);
                // 고객 진료 정보 삭제
                recordController.removeMedicalRecord(phoneNumber);
                break;
            }
        }
    }
    // 고객 등록 여부 확인
    public Customer findCustomers(String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return customer;
            }
        }

        return null;
    }

    // 고객 중복 확인
    public boolean isPhoneNumberExist(String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

}
