/* eslint no-use-before-define:0 */
<template>
  <v-container>
     <!--<v-app-bar app color="blue darken-2" dark>
       <v-app-bar-nav-icon></v-app-bar-nav-icon>  @click.stop="drawer = !drawer" 
      <v-toolbar-title>ระบบห้องสมุด</v-toolbar-title>
        <div class="flex-grow-1"></div>
    </v-app-bar>-->
     <v-container>
      <div>
        <v-responsive>
          <v-flex>
            <v-card class="mx-auto" max-width="80%">

              <v-toolbar color="blue darken-2" dark flat>
                <v-toolbar-title>ระบบคืนหนังสือ</v-toolbar-title>
              </v-toolbar>

              <v-card-text>
                <v-form>

                  <v-row>
                    <v-col cols="12">
                      <v-select
                              label="ชื่อสมาชิก"
                              outlined
                              v-model="borrowId"
                              :items="borrows"
                              item-text="member.name"
                              item-value="borrowId"
                              :rules="[(v) => !!v || 'Item is required']"
                              required
                      ></v-select>
                    </v-col>
                  </v-row>

                 <v-row>
                    <v-col cols="12">
                      <v-select
                              label="ประเภทหนังสือ"
                              outlined
                              v-model="typeId"
                              :items="bookTypes"
                              item-text="bookTypeName"
                              item-value="id"
                              :rules="[(v) => !!v || 'Item is required']"
                              required
                      ></v-select>
                    </v-col>
                  </v-row>

                  <v-row>
                    <v-col cols="12">
                      <v-select
                              label="ชื่อหนังสือ"
                              outlined
                              v-model="documentId"
                              :items="documents"
                              item-text="bookName"
                              item-value="id"
                              :rules="[(v) => !!v || 'Item is required']"
                              required
                      ></v-select>
                    </v-col>
                  </v-row>
                  <v-col cols="12">
                      <v-select
                              label="สภาพหนังสือ"
                              outlined
                              v-model="statusId"
                              :items="bookStatus"
                              item-text="bookStatusName"
                              item-value="id"
                              :rules="[(v) => !!v || 'Item is required']"
                              required
                      ></v-select>
                    </v-col>

                </v-form>
              </v-card-text>
              <v-card-actions>
                <!--<v-btn color="error">Clear</v-btn>-->
                <v-spacer></v-spacer>
                <v-btn color="blue darken-2" @click="addRemand">บันทึกข้อมูล</v-btn>
              </v-card-actions>

            </v-card>
          </v-flex>
        </v-responsive>
      </div>
    </v-container>
  </v-container>
</template>

<script>
import http from "../http-common";
export default {
  name: "remand",
  data() {
    return {          
            //เงื่อนไขในการบันทึกข้อมูล
        bookStatusId: "",
        typeId: "",
        borrowId:"",
        statusId: "",
        documentId:"",
      documents:[],
      bookStatus:[],
      bookTypes:[],
      borrows:[]

    };
  },
 methods: {               //สร้าง method เพื่ออ้างอิงในการรับข้อมูล
            /* eslint-disable no-console */
  getBookingStatus() {        //ดึงหลังบ้านเข้า combobox 
  http
      .get("/bookstatus")
      .then(response => {
      this.bookStatus = response.data;
    console.log(response.data);
    })
    .catch(e => {
    console.log(e);                   //ตัวตรวจจับ exception หรือ error
  });
  },
  getDocuments() {        //ดึงหลังบ้านเข้า combobox 
  http
      .get("/document")
      .then(response => {
      this.documents = response.data;
    console.log(response.data);
    })
    .catch(e => {
    console.log(e);                   //ตัวตรวจจับ exception หรือ error
  });
  },
            /* eslint-disable no-console */          
  getType() {         //ดึงหลังบ้านเข้า combobox 
    http
        .get("/booktype")
        .then(response => {
        this.bookTypes = response.data;
      console.log(response.data);
      })
      .catch(e => {
      console.log(e);
    });
  },
  /* eslint-disable no-console */

  getBorrow() {        //ดึงหลังบ้านเข้า combobox 
    http
        .get("/borrow")
        .then(response => {
        this.borrows = response.data;
      console.log(response.data);
      })
      .catch(e => {
      console.log(e);
    });
  },
  /* eslint-disable no-console */

  addRemand() {
    http
    .post(
        "/remand/" + this.typeId + "/"  + this.borrowId + "/" + this.statusId)
    .then(response => {
      console.log(response);
      alert('เพิ่มข้อมูลสำเร็จ');    
    })
    .catch(e => {
      console.log(e);
      alert('ไม่สามารถเพิ่มข้อมูลได้ '+ "/remand/" + this.typeId + "/"  + this.borrowId + "/" + this.statusId);
    });
  },
},
  mounted() {             //เรียกดึงข้อมูลจากหลังบ้า
    this.getDocuments();
    this.getBookingStatus();
    this.getType();
    // console.log("asdasdasd")
    this.getBorrow();
  }
};
</script>