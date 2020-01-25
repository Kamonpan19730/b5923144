package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Pattern;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DataJpaTest
public class MemberTests {

    private Validator validator;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private PrefixRepository prefixRepository;

    @Autowired
    private MemtypeRepository memtypeRepository;

    @BeforeEach
    public void setup() {
        final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testIdCardMustNotBeNull() {
        Member member= new Member();

        Province province = new Province();
        province.setProvince("ชัยภูมิ");
        province = provinceRepository.saveAndFlush(province);

        Prefix prefix = new Prefix();
        prefix.setPrefix("เด็กชาย");
        prefix = prefixRepository.saveAndFlush(prefix);

        Memtype memtype = new Memtype();
        memtype.setMemtype("นักศึกษา");
        memtype = memtypeRepository.saveAndFlush(memtype);

        member.setIdcard(null);
        member.setName("ABC");
        member.setProvince(province);
        member.setPrefix(prefix);
        member.setMemtype(memtype);

        Set<ConstraintViolation<Member>> result = validator.validate(member);

        assertEquals(1, result.size());

        ConstraintViolation<Member> violation = result.iterator().next();
        assertEquals("idcard Must Not Be Null", violation.getMessage());
        assertEquals("idcard", violation.getPropertyPath().toString());
    }
 
    @Test
    void testMemtypeMustNotBeNull() {
        Memtype memtype = new Memtype();
        memtype.setMemtype(null);
      

        Set<ConstraintViolation<Memtype>> result = validator.validate(memtype);
        assertEquals(1, result.size());

        ConstraintViolation<Memtype> violation = result.iterator().next();
        assertEquals("memtype Must Not Be Null", violation.getMessage());
        assertEquals("memtype", violation.getPropertyPath().toString());
    }
    
    @Test
    void testPrefixMustNotBeNull() {
        Prefix prefix = new Prefix();
        prefix.setPrefix(null);
      

        Set<ConstraintViolation<Prefix>> result = validator.validate(prefix);
        assertEquals(1, result.size());

        ConstraintViolation<Prefix> violation = result.iterator().next();
        assertEquals("prefix Must Not Be Null", violation.getMessage());
        assertEquals("prefix", violation.getPropertyPath().toString());
    }
   
   
    @Test
    void testProvinceMustNotBeNull() {
        Province province = new Province();
        province.setProvince(null);
      

        Set<ConstraintViolation<Province>> result = validator.validate(province);
        assertEquals(1, result.size());

        ConstraintViolation<Province> violation = result.iterator().next();
        assertEquals("province Must Not Be Null", violation.getMessage());
        assertEquals("province", violation.getPropertyPath().toString());
    }


    @Test
    void testIDcardOKWith13Digits() {
        Member member= new Member();

        Province province = new Province();
        province.setProvince("ชัยภูมิ");
        province = provinceRepository.saveAndFlush(province);

        Prefix prefix = new Prefix();
        prefix.setPrefix("เด็กชาย");
        prefix = prefixRepository.saveAndFlush(prefix);

        Memtype memtype = new Memtype();
        memtype.setMemtype("นักศึกษา");
        memtype = memtypeRepository.saveAndFlush(memtype);

        member.setIdcard("1234567890123");
        member.setName("ABC");
        member.setProvince(province);
        member.setPrefix(prefix);
        member.setMemtype(memtype);

        member = memberRepository.saveAndFlush(member);

        Optional<Member> found = memberRepository.findById(member.getMemberid());
        assertEquals("1234567890123", found.get().getIdcard());
    }


    // @Test
    // void testIDcardMustBeUnique() {
    //     Member member= new Member();

    //     Province province = new Province();
    //     province.setProvince("ชัยภูมิ");
    //     province = provinceRepository.saveAndFlush(province);

    //     Prefix prefix = new Prefix();
    //     prefix.setPrefix("เด็กชาย");
    //     prefix = prefixRepository.saveAndFlush(prefix);

    //     Memtype memtype = new Memtype();
    //     memtype.setMemtype("นักศึกษา");
    //     memtype = memtypeRepository.saveAndFlush(memtype);

    //     member.setIdcard("1234567890123");
    //     member.setName("ABC");
    //     member.setProvince(province);
    //     member.setPrefix(prefix);
    //     member.setMemtype(memtype);

    //     member = memberRepository.saveAndFlush(member);

    //     assertThrows(DataIntegrityViolationException.class, () -> {
    //         // สร้าง person object ตัวที่ 2
    //         Member member2 = new Member();

    //     Province province2 = new Province();
    //     province2.setProvince("ชัยภูมิ");
    //     province2 = provinceRepository.saveAndFlush(province2);

    //     Prefix prefix2 = new Prefix();
    //     prefix2.setPrefix("เด็กชาย");
    //     prefix2 = prefixRepository.saveAndFlush(prefix2);

    //     Memtype memtype2 = new Memtype();
    //     memtype2.setMemtype("นักศึกษา");
    //     memtype2 = memtypeRepository.saveAndFlush(memtype2);

    //     member2.setIdcard("1234567890123");
    //     member2.setName("ABC");
    //     member2.setProvince(province2);
    //     member2.setPrefix(prefix2);
    //     member2.setMemtype(memtype2);

    //     member2 = memberRepository.saveAndFlush(member2);
    //     });






    




        @Test
    void testIDcardMustNotBe14Digits() {
        Member member= new Member();

        Province province = new Province();
        province.setProvince("ชัยภูมิ");
        province = provinceRepository.saveAndFlush(province);

        Prefix prefix = new Prefix();
        prefix.setPrefix("เด็กชาย");
        prefix = prefixRepository.saveAndFlush(prefix);

        Memtype memtype = new Memtype();
        memtype.setMemtype("นักศึกษา");
        memtype = memtypeRepository.saveAndFlush(memtype);

        member.setIdcard("12345678901234");
        member.setName("ABC");
        member.setProvince(province);
        member.setPrefix(prefix);
        member.setMemtype(memtype);

        Set<ConstraintViolation<Member>> result = validator.validate(member);

        // result ต้องมี error 1 ค่าเท่านั้น
        assertEquals(1, result.size());

        // error message ตรงชนิด และถูก field
        ConstraintViolation<Member> v = result.iterator().next();

        assertEquals("idcard Must Have 13 digits", v.getMessage());
        assertEquals("idcard", v.getPropertyPath().toString());
    }


    @Test
    void testIDcardMustNotBe12Digits() {
        Member member= new Member();

        Province province = new Province();
        province.setProvince("ชัยภูมิ");
        province = provinceRepository.saveAndFlush(province);

        Prefix prefix = new Prefix();
        prefix.setPrefix("เด็กชาย");
        prefix = prefixRepository.saveAndFlush(prefix);

        Memtype memtype = new Memtype();
        memtype.setMemtype("นักศึกษา");
        memtype = memtypeRepository.saveAndFlush(memtype);

        member.setIdcard("123456789012");
        member.setName("ABC");
        member.setProvince(province);
        member.setPrefix(prefix);
        member.setMemtype(memtype);

        Set<ConstraintViolation<Member>> result = validator.validate(member);

        // result ต้องมี error 1 ค่าเท่านั้น
        assertEquals(1, result.size());

        // error message ตรงชนิด และถูก field
        ConstraintViolation<Member> v = result.iterator().next();

        assertEquals("idcard Must Have 13 digits", v.getMessage());
        assertEquals("idcard", v.getPropertyPath().toString());
    }



    @Test
    void testNameMustNotBeNull() {
        Member member= new Member();

        Province province = new Province();
        province.setProvince("ชัยภูมิ");
        province = provinceRepository.saveAndFlush(province);

        Prefix prefix = new Prefix();
        prefix.setPrefix("เด็กชาย");
        prefix = prefixRepository.saveAndFlush(prefix);

        Memtype memtype = new Memtype();
        memtype.setMemtype("นักศึกษา");
        memtype = memtypeRepository.saveAndFlush(memtype);

        member.setIdcard("1234567890123");
        member.setName(null);
        member.setProvince(province);
        member.setPrefix(prefix);
        member.setMemtype(memtype);

        Set<ConstraintViolation<Member>> result = validator.validate(member);

        assertEquals(1, result.size());

        ConstraintViolation<Member> violation = result.iterator().next();
        assertEquals("Name Must Not Be Null", violation.getMessage());
        assertEquals("name", violation.getPropertyPath().toString());
    }
 
}


















