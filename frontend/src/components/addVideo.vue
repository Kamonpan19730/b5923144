<template>
  <v-container>
    <!-- <v-app-bar app color="blue darken-2" dark>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>ระบบจัดเก็บวีดีโอ</v-toolbar-title>
    </v-app-bar> -->
     <v-container>
      <div>
        <v-responsive>
          <v-flex>
            <v-card class="mx-auto" max-width="80%">
              <v-toolbar color="blue darken-2" dark flat>
                <v-toolbar-title>ระบบจัดเก็บวีดีโอ</v-toolbar-title>

              </v-toolbar>

              <v-card-text>
                <v-form>
                  <v-row>
                    <v-col cols="12">
                      <v-select
                              label="ชื่อบรรณารักษ์"
                              outlined
                              v-model="video.librarianid"
                              :items="librarian"
                              item-text="librarianName"
                              item-value="librarianid"
                              :rules="[(v) => !!v || 'กรุณาเลือกชื่อบรรณารักษ์']"
                              required
                      ></v-select>
                    </v-col>
                  </v-row>

                  <v-col cols="12">
                    <v-text-field
                            label="กรอกชื่อวีดีโอ"
                            name="videoName"
                            type="text"
                            v-model="video.videoName"
                            :rules="[(v) => !!v || 'กรุณากรอกชื่อวีดีโอ']"
                            required
                    ></v-text-field>
                  </v-col>

                  <v-row>
                    <v-col cols="12">
                      <v-select
                              label="เลือกประเภทของวีดีโอ"
                              outlined
                              v-model="video.typeid"
                              :items="type"
                              item-text="type"
                              item-value="typeid"
                              :rules="[(v) => !!v || 'กรุณาเลือกประเภทของวีดีโอ']"
                              required
                      ></v-select>
                    </v-col>
                  </v-row>

                  <v-row>
                    <v-col cols="12">
                      <v-select
                              label="เลือกหมวดหมู่ของวีดีโอ"
                              outlined
                              v-model="video.categoryid"
                              :items="category"
                              item-text="category"
                              item-value="categoryid"
                              :rules="[(v) => !!v || 'กรุณาเลือกหมวดหมู่ของวีดีโอ']"
                              required
                      ></v-select>
                    </v-col>
                  </v-row>

                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-btn color="blue darken-2" @click="saveVideo">บันทึกข้อมูล</v-btn>
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
  name: "video",
  data() {
    return {
      video: {
        librarianid: "",
        videoName:"",
        typeid: "",
        categoryid: "",
      },
      librarian:[],
      type:[],
      category:[],
    };
  },
  methods: {
    /* eslint-disable no-console */
     /* eslint-disable */
    getCreateLibrarian() {
      http
        .get("/librarian")
        .then(response => {
          console.log(response.data);
          this.$forceUpdate();
          this.librarian = response.data;
          
        })
        .catch(e => {
          console.log(e);
        });
    },

    getCreatType() {
      http
        .get("/type")
        .then(response => {
          console.log(response.data);
          this.$forceUpdate();
          this.type = response.data;
        })
        .catch(e => {
          console.log(e);
        });
    },

    getCreatCategory() {
      http
        .get("/category")
        .then(response => {
          this.$forceUpdate();
          this.category = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    saveVideo() {
      console.log(this.video.librarianid)
      console.log(this.video.videoName)
      console.log(this.video.typeid)
      console.log(this.video.categoryid)
      http
        .post(
          ////addVideo/{librarianid}/{videoName}/{typeid}/{categoryid}
            "/addVideo/" +
            this.video.librarianid +
            "/" +
            this.video.videoName +
            "/" +
            this.video.typeid +
            "/" +
            this.video.categoryid ,
            this.video
        )
        .then(response => {
          console.log(response);
          alert('เพิ่มข้อมูลสำเร็จ');    
        })
        .catch(e => {
          console.log(e);
          alert('ไม่สามารถเพิ่มข้อมูลได้');
        });
    },
    refreshList() {
      this.getCreateLibrarian();
      this.getCreatType();
      this.getCreatCategory();
    }
  },
  mounted() {
    this.getCreateLibrarian();
      this.getCreatType();
      this.getCreatCategory();
  }
};
</script>
