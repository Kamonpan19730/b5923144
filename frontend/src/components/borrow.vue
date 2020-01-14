<template>
  <v-container>
    <!-- <v-app-bar app color="blue darken-2" dark>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>ระบบห้องสมุด</v-toolbar-title>
    </v-app-bar>-->
    <v-container>
      <div>
        <v-responsive>
          <v-flex>
            <v-card class="mx-auto" max-width="80%">
              <v-toolbar color="blue darken-2" dark flat>
                <v-toolbar-title>ระบบยืมหนังสือ</v-toolbar-title>
              </v-toolbar>
              <v-card-text>
                <v-form>
                  <v-row>
                    <v-col cols="12">
                      <v-select
                        label="เลือกชื่อสมาชิก"
                        outlined
                        v-model="borrow.memberId"
                        :items="Member"
                        item-text="name"
                        item-value="memberid"
                        :rules="[(v) => !!v || 'Item is required']"
                        required
                      ></v-select>
                    </v-col>
                  </v-row>

                  <v-row>
                    <v-col cols="12">
                      <v-select
                        label="เลือกประเภทหนังสือ"
                        outlined
                        v-model="borrow.booktypeId"
                        :items="BookTypes"
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
                        label="เลือกชื่อหนังสือ"
                        outlined
                        v-model="borrow.booknameId"
                        :items="Documents"
                        item-text="bookName"
                        item-value="id"
                        :rules="[(v) => !!v || 'Item is required']"
                        required
                      ></v-select>
                    </v-col>
                  </v-row>

                  <v-col cols="12">
                    <v-text-field
                      label="จำนวนเล่ม"
                      name="name"
                      type="text"
                      v-model="borrow.numbers"
                      :rules="[(v) => !!v || 'Please fill in the information']"
                      required
                    ></v-text-field>
                  </v-col>

                  <v-row>
                    <v-col cols="12">
                      <v-select
                        label="เลือกประเภทสมาชิก"
                        outlined
                        v-model="borrow.memtpeId"
                        :items="Memtype"
                        item-text="memtype"
                        item-value="memtypeid"
                        :rules="[(v) => !!v || 'Item is required']"
                        required
                      ></v-select>
                    </v-col>
                  </v-row>
                </v-form>

                <v-snackbar v-model="snackbar">
                  {{ text }}
                  <v-btn color="pink" text @click="snackbar = false">Close</v-btn>
                </v-snackbar>
              </v-card-text>
              <v-card-actions>
                <v-btn color="error" @click="clear">Clear</v-btn>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-2" @click="saveBorrow">Save</v-btn>
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
// eslint-disable-next-line no-unused-vars
export default {
  name: "borrow",
  data() {
    return {
      borrow: {
        memberId: "",
        booktypeId: "",
        booknameId: "",
        numbers: "",
        memtpeId: ""
      },
      snackbar: false,
      text: ""
    };
  },
  methods: {
    /* eslint-disable no-console */
    // ดึงข้อมูล Employee ใส่ combobox
    getCreatMember() {
      http
        .get("/member")
        .then(response => {
          this.$forceUpdate();
          this.Member = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    getCreatBookType() {
      http
        .get("/booktype")
        .then(response => {
          this.$forceUpdate();
          this.BookTypes = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล Video ใส่ combobox
    getCreatDocument() {
      http
        .get("/document")
        .then(response => {
          this.$forceUpdate();
          this.Documents = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล RentalType ใส่ combobox
    getCreatMemType() {
      http
        .get("/memtype")
        .then(response => {
          this.$forceUpdate();
          this.Memtype = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    saveBorrow() {
      console.log(this.borrow);
      http
        .post(
          //borrow/{numbers}/{member_id}/{bookType_id}/{document_id}/{memType_id}"
          "/borrow/" +
            parseInt(this.borrow.numbers, 10) +
            "/" +
            this.borrow.memberId +
            "/" +
            this.borrow.booktypeId +
            "/" +
            this.borrow.booknameId +
            "/" +
            this.borrow.memtpeId
        )
        .then(response => {
          console.log(response);
          this.text = "เพิ่มข้อมูลสำเร็จ"
          this.snackbar = !this.snackbar
        })
        .catch(e => {
          console.log(e);
          this.text = "ไม่สามารถเพิ่มข้อมูลได้"
          this.snackbar = !this.snackbar
        })
      this.submitted = true;
    },
    clear() {
      this.borrow.memberId = "";
      this.borrow.booktypeId = "";
      this.borrow.booknameId = "";
      this.borrow.numbers = "";
      this.borrow.memtpeId = "";
    },
    refreshList() {
      this.getCreatMember();
      this.getCreatBookType();
      this.getCreatDocument();
      this.getCreatMemType();
    }
    /* eslint-enable no-console */
  },
  created() {
    this.getCreatMember();
    this.getCreatBookType();
    this.getCreatDocument();
    this.getCreatMemType();
  }
};
</script>