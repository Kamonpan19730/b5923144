// package com.example.demo;

// import static org.junit.Assert.assertEquals;

// import java.util.Date;
// import java.util.Optional;
// import java.util.Set;

// import javax.validation.ConstraintViolation;
// import javax.validation.Validation;
// import javax.validation.Validator;
// import javax.validation.ValidatorFactory;

// import com.example.demo.entity.*;

// import com.example.demo.repository.*;


// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit4.SpringRunner;

// @DataJpaTest
// // @SpringBootTest
// @RunWith(SpringRunner.class)
// public class MemberTests {
//     private Validator validator;
//     @Autowired
//     private MemberRepository memberRepository;

//     @Autowired
//     private MemtypeRepository memtypeRepository;

//     @Autowired
//     private PrefixRepository prefixRepository;

//     @Autowired
//     private ProvinceRepository provinceRepository;

//     private Member member;
//     private Memtype memtype;
//     private Prefix prefix;
//     private Province province;

//     @Before
//     public void setup() {
//         ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//         validator = factory.getValidator();

//         prefix = Prefix.builder().prefix("Dr.").build();
//         prefix = prefixRepository.saveAndFlush(prefix);

//         province = Province.builder().province("Bangkok").build();
//         province = provinceRepository.saveAndFlush(province);

//         memtype = Memtype.builder().memtype("Government").build();
//         memtype = memtypeRepository.saveAndFlush(memtype);

//         member = Member.builder().idcard("ASD123").memtype(memtype).name("Paknahee").prefix(prefix).province(province)
//                 .build();
//         member = memberRepository.saveAndFlush(member);

    
//     }

//     @After
//     public void destroy() {
//         prefixRepository.deleteAll();
//         provinceRepository.deleteAll();
//         memtypeRepository.deleteAll();
//         memberRepository.deleteAll();    
//     }

//     @Test
//     public void B5923403_borrowShouldBeOK() {
//         Member member = Member.builder().member(member).memtype(memtype).build();
//         member = memberRepository.saveAndFlush(member);

//         Optional<Borrow> found = memberRepository.findById(member.getMemberID());
    
       
//         assertEquals("Dr.", found.get().getMember().getPrefix().getPrefix());
//         assertEquals("Bangkok", found.get().getMember().getProvince().getProvince());
//         assertEquals("Government", found.get().getMemtype().getMemtype());
//         assertEquals("ASD123", found.get().getMember().getIdcard());
//         assertEquals("Paknahee", found.get().getMember().getName());
//     }

//     // @Test
//     // public void B5923403_memberMustBeNotNull() {
//     //     Borrow borrow = Borrow.builder().Descripton("Hentai Comic").bookType(bookType).borrowDate(new Date())
//     //             .document(document).member(null).memtype(memType).numbers(1L).tell("0987451150").build();

//     //     Set<ConstraintViolation<Borrow>> result = validator.validate(borrow);
//     //     assertEquals(1, result.size());
//     //     ConstraintViolation<Borrow> violation = result.iterator().next();
//     //     assertEquals("member must be not null", violation.getMessage());
//     //     assertEquals("member", violation.getPropertyPath().toString());
//     // }

//     // @Test
//     // public void B5923403_descriptionMustBeMax25Character() {
//     //     Borrow borrow = Borrow.builder().Descripton("abcdefghijklmnopqrstuvwxyz").bookType(bookType)
//     //             .borrowDate(new Date()).document(document).member(member).memtype(memType).numbers(1L)
//     //             .tell("0987451150").build();

//     //     Set<ConstraintViolation<Borrow>> result = validator.validate(borrow);
//     //     assertEquals(1, result.size());
//     //     ConstraintViolation<Borrow> violation = result.iterator().next();
//     //     assertEquals("description must be max 25 characters", violation.getMessage());
//     //     assertEquals("Descripton", violation.getPropertyPath().toString());
//     // }

//     // @Test
//     // public void B5923403_tellMustBeNumber() {
//     //     Borrow borrow = Borrow.builder().Descripton("Hentai Comic").bookType(bookType).borrowDate(new Date())
//     //             .document(document).member(member).memtype(memType).numbers(1L).tell("asdfghjklm").build();

//     //     Set<ConstraintViolation<Borrow>> result = validator.validate(borrow);
//     //     assertEquals(1, result.size());
//     //     ConstraintViolation<Borrow> violation = result.iterator().next();
//     //     assertEquals("tell must be digit and 10 characters", violation.getMessage());
//     //     assertEquals("tell", violation.getPropertyPath().toString());
//     // }

//     // @Test
//     // public void B5923403_tellMustNot11Characters() {
//     //     Borrow borrow = Borrow.builder().Descripton("Hentai Comic").bookType(bookType).borrowDate(new Date())
//     //             .document(document).member(member).memtype(memType).numbers(1L).tell("09632587412").build();

//     //     Set<ConstraintViolation<Borrow>> result = validator.validate(borrow);
//     //     assertEquals(1, result.size());
//     //     ConstraintViolation<Borrow> violation = result.iterator().next();
//     //     assertEquals("tell must be digit and 10 characters", violation.getMessage());
//     //     assertEquals("tell", violation.getPropertyPath().toString());
//     // }


//     // @Test
//     // public void B5923403_tellMustNot9Characters() {
//     //     Borrow borrow = Borrow.builder().Descripton("Hentai Comic").bookType(bookType).borrowDate(new Date())
//     //             .document(document).member(member).memtype(memType).numbers(1L).tell("096325874").build();

//     //     Set<ConstraintViolation<Borrow>> result = validator.validate(borrow);
//     //     assertEquals(1, result.size());
//     //     ConstraintViolation<Borrow> violation = result.iterator().next();
//     //     assertEquals("tell must be digit and 10 characters", violation.getMessage());
//     //     assertEquals("tell", violation.getPropertyPath().toString());
//     // }


















//     // @Test
//     // public void b5923403_testNotnull() {

//     // Borrow borrow =
//     // Borrow.builder().numbers(null).Descripton("abcdefghijklmnopqrstuvwxy")
//     // .borrowDate(new Date())

//     // .tell("0812345678").build();

//     // Set<ConstraintViolation<Borrow>> result = validator.validate(borrow);
//     // assertEquals(1, result.size());
//     // ConstraintViolation<Borrow> violation = result.iterator().next();
//     // assertEquals("Notnull", violation.getMessage());
//     // assertEquals("numbers", violation.getPropertyPath().toString());
//     // }

//     // @Test
//     // public void b5923403_testSize() {

//     // Borrow borrow =
//     // Borrow.builder().numbers(1L).Descripton("abcdefghijklmnopqrstuvwxyz").borrowDate(new
//     // Date())
//     // .tell("0812345678").build();
//     // Set<ConstraintViolation<Borrow>> result = validator.validate(borrow);
//     // assertEquals(1, result.size());
//     // ConstraintViolation<Borrow> violation = result.iterator().next();
//     // assertEquals("Joe", violation.getMessage());
//     // assertEquals("Descripton", violation.getPropertyPath().toString());
//     // }

//     // @Test
//     // public void b5923403_testPattern() {

//     // Borrow borrow =
//     // Borrow.builder().numbers(1L).Descripton("abcdefghijklmnopqrstuvwxy").borrowDate(new
//     // Date())
//     // .tell("01234").build();
//     // Set<ConstraintViolation<Borrow>> result = validator.validate(borrow);
//     // assertEquals(1, result.size());
//     // ConstraintViolation<Borrow> violation = result.iterator().next();
//     // assertEquals("error", violation.getMessage());
//     // assertEquals("tell", violation.getPropertyPath().toString());
//     // }

// }
