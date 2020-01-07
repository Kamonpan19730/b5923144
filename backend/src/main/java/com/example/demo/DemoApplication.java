package com.example.demo;

import com.example.demo.repository.LibrarianRepository;
import com.example.demo.repository.*;
import com.example.demo.repository.MemtypeRepository;
import com.example.demo.repository.TypeRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.entity.*;
import com.example.demo.entity.Type;
import com.example.demo.entity.Category;
import com.example.demo.entity.Librarian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	ApplicationRunner init(TypeRepository typeRepository, CategoryRepository categoryRepository, LibrarianRepository librarianRepository,
						MemberRepository memberRepository,
						MemtypeRepository memtypeRepository,
						PrefixRepository prefixRepository,
						ProvinceRepository provinceRepository) {
	
		return args -> {
			Stream.of("AAA").forEach(type -> {
				Type types = new Type();
				types.setType(type);
				typeRepository.save(types);
			});

			Stream.of("SSSS").forEach(category -> {
				Category categorys = new Category();
				categorys.setCategory(category);
				categoryRepository.save(categorys);
			});

			Stream.of("กระบี่","กรุงเทพมหานคร","กาญจนบุรี","กาฬสินธุ์","กำแพงเพชร","ขอนแก่น","จันทบุรี","ฉะเชิงเทรา" ,"ชลบุรี",
			"ชัยนาท","ชัยภูมิ","ชุมพร","เชียงราย","เชียงใหม่","ตรัง","ตราด","ตาก","นครนายก","นครปฐม","นครพนม",
			"นครราชสีมา" ,"นครศรีธรรมราช","นครสวรรค์","นนทบุรี","นราธิวาส","น่าน","บุรีรัมย์","บึงกาฬ","ปทุมธานี",
			"ประจวบคีรีขันธ์","ปราจีนบุรี","ปัตตานี" ,"พะเยา","พังงา","พัทลุง","พิจิตร","พิษณุโลก","เพชรบุรี","เพชรบูรณ์",
			"แพร่","ภูเก็ต","มหาสารคาม","มุกดาหาร","แม่ฮ่องสอน" ,"ยโสธร","ยะลา","ร้อยเอ็ด","ระนอง","ระยอง","ราชบุรี",
			"ลพบุรี","ลำปาง","ลำพูน","เลย","ศรีสะเกษ","สกลนคร","สงขลา" ,"สตูล","สมุทรปราการ","สมุทรสงคราม","สมุทรสาคร",
			"สระแก้ว","สระบุรี","สิงห์บุรี","สุโขทัย","สุพรรณบุรี","สุราษฎร์ธานี" ,"สุรินทร์","หนองคาย","หนองบัวลำภู","อยุธยา",
			"อ่างทอง","อำนาจเจริญ","อุดรธานี","อุตรดิตถ์","อุทัยธานี","อุบลราชธานี").forEach(pro -> {
		Province province = new Province();
		province.setProvince(pro);
		provinceRepository.save(province);
	});


	Stream.of("เด็กชาย","เด็กหญิง","นาย","นางสาว","นาง").forEach(prefix -> {
		Prefix prefixx = new Prefix();
		prefixx.setPrefix(prefix);
		prefixRepository.save(prefixx);
	});


	Stream.of("นักเรียน","นักศึกษา","บุคคลทั่วไป").forEach(memtpye -> {
		Memtype memtypee = new Memtype();
		memtypee.setMemtype(memtpye);
		memtypeRepository.save(memtypee);
	});




		};
	}
}
