<template>

    <center>
      <v-form v-model="valid" ref="form"> 
          <v-card class="mx-auto" max-width="100%">
                 <v-row>
                    <v-col>
                      
                   
                     <v-card color="basil">
                    <v-card-title class="text-center justify-center py-6">
                   <h1 class="font-weight display-1 basil--text">ระบบลงทะเบียนสมาชิก</h1>
                   </v-card-title>
                   </v-card>  
                    

                    </v-col>
                  </v-row>
               

<v-card-text>
                    <v-row>
                         <v-col cols="12">
                        <v-select
                            label="โปรดเลือกคำนำหน้า"
                            outlined

                            v-model="Member.prefixid"
                            :items="prefix"
                                   :rules="[v=> !!v || 'โปรดเลือกคำนำหน้า']"
                            item-text="prefix"   
                            item-value="prefixid"
                        
                        required
                        ></v-select>
                        </v-col>
                    </v-row>   



                    <v-row>
                        <v-col>
                            <v-text-field
                            
                                label="ชื่อ-นามสกุล"
                                hint="กรอกชื่อ-นามสกุล"

                                required
                                v-model="Member.name"
                            ></v-text-field>
                            </v-col>
                    </v-row>


                    <v-row>
                        <v-col>
                            <v-text-field
                                label="เลขประจำตัวบัตรประชาชน 13 หลัก"
                                hint="กรอกเลขประจำตัวบัตรประชาชน 13 หลัก"

                                required
                                v-model="Member.idcard"
                            ></v-text-field>
                            </v-col>
                    </v-row>

                    <v-row>
                        <v-col>
                        <v-select
                            label="โปรดเลือกจังหวัด"
                            outlined

                            v-model="Member.provinceid"
                            :items="province"
                            :rules="[v=> !!v || 'โปรดเลือกจังหวัด']"
                            item-text="province"   
                            item-value="provinceid"
                        
                        required
                        ></v-select>
                        </v-col>
                    </v-row>   


                   <v-row>
                        <v-col>
                        <v-select
                            label="โปรดเลือกประเภทสมาชิก"
                            outlined

                            v-model="Member.memtypeid"
                            :items="memtype"
                            :rules="[v=> !!v || 'โปรดเลือกประเภทสมาชิก']"
                            item-text="memtype"   
                            item-value="memtypeid"
                        
                        required
                        ></v-select>
                        </v-col>
                    </v-row>   
                    
                    
                 
</v-card-text>

                    <v-row justify="center">
                        <v-col cols="12">
                            <v-btn @click="saveMember" :class="{ yellow: !valid, green: valid }" color="primary">บันทึกข้อมูล</v-btn>&nbsp;&nbsp;&nbsp;
                            
                            
                        </v-col>
                        </v-row>
                    </v-card>    
      </v-form>
   </center>
    
</template>





<script>
    import http from "../http-common";

    export default {
        name: "Member",
         data() {
    return {
      Member:{
        prefixid: "",
        name: "",
        idcard: "",
        provinceid: "",
        memtypeid: "",
        
        active: false
        },
        submitted: false,
        valid: false,
    };
  },
methods: {
   /* eslint-disable */
    getPrefix(){
      http
        .get("/prefix")
        .then(response => {
          this.$forceUpdate();   //เผื่อข้อมูลไม่ขึ้นในคอมโบ
          this.prefix = response.data; //
          console.log(this.prefix);  //คำสั่งปริ้นว่าส่ง obj หลังบ้านออกมาหน้าบ้านได้มั้ย

        })
        .catch(e => {
          console.log(e);
        });
  }, 
  getProvince(){
      http
        .get("/province")
        .then(response => {
          this.$forceUpdate();
          this.province = response.data;
          //ไม่ต้งเติมs เอามาแค่ชื่อ ตารางพอ
          console.log(response.data);
        })
        .catch(e => {   //แจ้งเตือน ดักจับ error
          console.log(e);
        });
    
  },
    getMemtype(){
      http
        .get("/memtype")
        .then(response => {
        this.$forceUpdate();
         this.memtype = response.data;
         //ไม่มี s
         console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    
  },
   
   saveMember() {
      http
        .post( ///addmember/{prefixid}/{name}/{idcard}/{provinceid}/{memtypeid}"
          "/member/" +
            this.Member.prefixid +
            "/" +
            this.Member.name +
            "/" +
            this.Member.idcard +
            "/" +
            this.Member.provinceid +
            "/" +
            this.Member.memtypeid,
          this.Member
        )
    .then(response => {
          console.log(response);
          if(response = true){
            alert('บันทึกข้อมูลเสร็จสิ้น')
          } 
          this.$refs.form.reset();
       //   this.customerCheck = false;
        })
        .catch(e => {
          console.log(e);
           if(e = false){
            alert('การบันทึกข้อมูลผิดพลาด')
          }
        });
      
     
    },
   
  },
    mounted() {
      this.getPrefix();
      this.getProvince();
      this.getMemtype();
  }
  
};
</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->
<style  scoped,lang="scss" scoped>
    .v-app-bar{
    margin-top: 1px;
    background-color:rgb(75, 73, 238)  
  }

  .v-form {
      width: 55%;
      background-color:rgb(250, 250, 250)
    }
    
  .v-btn{
      background-color:rgba(250, 250, 250)
  }

.basil {
  background-color: rgb(69, 91, 219) !important;
}
.basil--text {
  color: #edf5f2 !important;
}
</style>

