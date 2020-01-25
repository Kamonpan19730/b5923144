<template>  <v-navigation-drawer
     
     
      src="https://scontent.fbkk12-1.fna.fbcdn.net/v/t1.15752-9/s2048x2048/83019207_707637426433882_8480522138380402688_n.png?_nc_cat=106&_nc_oc=AQkWeQcUbFRfw3NgHAHI9otJ9B_7yAm2Ci8veXoTm9WPm1E_9aVeK8Mx-3hokTCWgZE&_nc_ht=scontent.fbkk12-1.fna&oh=39915d8268d69a13b49bfa3e86baeaf7&oe=5E942AFD"
      width="500%"
      height="700"
    
    >
 
   
  
    <v-layout text-center wrap>
      <v-flex mb-4>
        <br />
        <br />
        <br />
           
          <v-toolbar-title color="error">รายชื่อผู้ลงทะเบียนสมาชิก</v-toolbar-title>
        
    
       
      </v-flex>
    </v-layout>

    <v-row justify="center">
      <v-col cols="8">
        <v-data-table :headers="headers" :items="items" :items-per-page="5" class="elevation-1">
        </v-data-table>
      </v-col>
    </v-row>

  
  
   
 
  </v-navigation-drawer>
</template>


<script>
import http from "../http-common";
export default {
  name: "ShowMember",
  data() {
    return {
      headers: [
        { text: "คำนำหน้า", value: "prefix.prefix" } ,
        { text: "ชื่อ-สกุล", value: "name" } ,
        { text: "เลขประจำตัวบัตรประชาชน", value: "idcard" } ,
        {text: "จังหวัด", value: "province.province" } ,
        {text: "ประเภทสมาชิก", value: "memtype.memtype" }    
      ],
      items: [],
    };
  },
  methods: {
    /* eslint-disable no-console */
    // ดึงข้อมูล receipt ใส่ combobox
    getMember() {
      http
        .get("/member")
        .then(response => {
          this.$forceUpdate(); 
          this.items = response.data;
          console.log(this.items);
        })
        .catch(e => {
          console.log(e);
        });
    },

    
    /* eslint-disable no-console */
  },
  mounted() {
    this.getMember();
  }
};
</script>

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
      background-color:rgb(250, 250, 250)
  }

.basil {
  background-color: rgb(69, 91, 219) !important;
}
.basil--text {
  color: #edf5f2 !important;
}
</style>
