package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.PrefixRepository;
import com.example.demo.repository.ProvinceRepository;
import com.example.demo.repository.MemtypeRepository;

import com.example.demo.entity.Member;
import com.example.demo.entity.Memtype;
import com.example.demo.entity.Prefix;
import com.example.demo.entity.Province;


@RestController
@CrossOrigin(origins = "http://localhost:8080")


public class MemberController {

    @Autowired
    private final MemberRepository memberRepository; //เห็นเฉพาะ 

    @Autowired
    private MemtypeRepository memtypeRepository;

    @Autowired
    private PrefixRepository prefixRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    MemberController(MemberRepository memberRepository){   //เซทคอนตัคเตอธรรมดา
        this.memberRepository = memberRepository;
    }


    @GetMapping("/member")   
    public Collection<Member> Member() {
        return memberRepository.findAll().stream().collect(Collectors.toList());

    }

        @PostMapping("/addmember/{prefixid}/{name}/{idcard}/{provinceid}/{memtypeid}")
        public Member newMember(Member newMember,
                                  @PathVariable long prefixid,
                                  @PathVariable String name,
                                  @PathVariable int idcard,
                                  @PathVariable long provinceid,
                                  @PathVariable long memtypeid) {

            Prefix prefix = prefixRepository.findById(prefixid);
            Province province = provinceRepository.findById(provinceid);
            Memtype memtype = memtypeRepository.findById(memtypeid);

            newMember.setPrefix(prefix);
            newMember.setName(name);
            newMember.setIdcard(idcard);
            newMember.setProvince(province);
            newMember.setMemtype(memtype);
        
            return memberRepository.save(newMember);

        
        }


}