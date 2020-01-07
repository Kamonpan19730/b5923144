package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;


@SpringBootApplication
public class DemoApplicationTests {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplicationTests.class, args);
	}
	@Bean
	ApplicationRunner init(MemberRepository memberRepository,
						   PrefixRepository prefixRepository,
						   MemtypeRepository memtypeRepository,
						   ProvinceRepository provinceRepository) {
		return args -> {
			Stream.of("นาย","นาง","นางสาว","เด็กหญิง","เด็กชาย").forEach(prefix -> {
				Prefix prefixx = new Prefix();
				prefixx.setPrefix(prefix);
				prefixRepository.save(prefixx);
			});

		    Stream.of("นักเรียน","นักศึกษา").forEach(memtype -> {
				Memtype memtypee = new Memtype();
				memtypee.setMemtype(memtype);
				memtypeRepository.save(memtypee);
			});

			Stream.of("กระบี่","กรุงเทพมหานคร","กาญจนบุรี","กาฬสินธุ์","กำแพงเพชร","ขอนแก่น","จันทบุรี","ฉะเชิงเทรา" ,"ชลบุรี",
					"ชัยนาท","ชัยภูมิ","ชุมพร","เชียงราย","เชียงใหม่","ตรัง","ตราด","ตาก","นครนายก","นครปฐม","นครพนม",
					"นครราชสีมา" ,"นครศรีธรรมราช","นครสวรรค์","นนทบุรี","นราธิวาส","น่าน","บุรีรัมย์","บึงกาฬ","ปทุมธานี",
					"ประจวบคีรีขันธ์","ปราจีนบุรี","ปัตตานี" ,"พะเยา","พังงา","พัทลุง","พิจิตร","พิษณุโลก","เพชรบุรี","เพชรบูรณ์",
					"แพร่","ภูเก็ต","มหาสารคาม","มุกดาหาร","แม่ฮ่องสอน" ,"ยโสธร","ยะลา","ร้อยเอ็ด","ระนอง","ระยอง","ราชบุรี",
					"ลพบุรี","ลำปาง","ลำพูน","เลย","ศรีสะเกษ","สกลนคร","สงขลา" ,"สตูล","สมุทรปราการ","สมุทรสงคราม","สมุทรสาคร",
					"สระแก้ว","สระบุรี","สิงห์บุรี","สุโขทัย","สุพรรณบุรี","สุราษฎร์ธานี" ,"สุรินทร์","หนองคาย","หนองบัวลำภู","อยุธยา",
					"อ่างทอง","อำนาจเจริญ","อุดรธานี","อุตรดิตถ์","อุทัยธานี","อุบลราชธานี").forEach(province -> {
				Province provincee = new Province();
				province.setProvince(province);
				provinceRepository.save(provincee);
			});
		//ลบเลยใช้  stream ไปแล้ว ตรงนี้มันเหมือนกันกับ stream
			// Member member = new Member();
			// member.setName("Mai Mai");
			// member.setIdcard(20);
			// member.setProvince(provinceRepository.getOne(2L));
			// member.setPersonnel(personnelRepository.getOne(1L));
			// member.setDisease(diseaseRepository.getOne(3L));
			// patientRepository.save(patient);
		};


	}
}

