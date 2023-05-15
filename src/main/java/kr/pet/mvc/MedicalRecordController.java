package kr.pet.mvc;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordController {
    private List<MedicalRecord> records = new ArrayList<>();

    // 진료기록 등록
    public void addMedicalRecord(MedicalRecord record) {
        records.add(record);
    }
    // 진료기록 삭제
    public void removeMedicalRecord(String phoneNumber) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getPhoneNumber().equals(phoneNumber)) {
                records.remove(i);
                break;
            }
        }
    }

    // 검색 기능
    public List<MedicalRecord> findMedicalRecord(String phoneNumber) {
        List<MedicalRecord> result = new ArrayList<>();
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getPhoneNumber().equals(phoneNumber)) {
                result.add(records.get(i));
                break;
            }
        }
        return result;
    }
}
