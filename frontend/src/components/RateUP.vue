<template>
    <v-app>
        <v-card class="mx-auto" width="50%">
            <v-container>
                <v-card-title class = "display-1">ระบบให้คะแนนการใช้งาน</v-card-title>
                <v-form ref="form">
                    <v-select
                        v-model="rateup.status"
                        :items="status"
                        :rules="[v=> !!v || 'Choose your status']"
                        label="ระบุสถานะการสมรส :"
                        required
                    ></v-select>
                    <v-select
                        v-model="rateup.edlevel"
                        :items="edlevel"
                        :rules="[v=> !!v || 'Choose your Education Level']"
                        label="เลือกระดับการศึกษา :"
                        required
                        ></v-select>
                    
                        <v-container>
                            <v-card-text>
                                <v-text-field v-model="rateup.email"  label="Your Email" required></v-text-field>
                                <v-textarea v-model="rateup.suggestion" :rules="[v=> !!v || 'ระบุคำแนะนำติชม กับการใช้งานของท่าน']">
                                    <template v-slot:label>
                                        <div>
                                            คำแนะนำติชม
                                            <small>(โปรดระบุ)</small>
                                        </div>
                                    </template>
                                </v-textarea>
                            </v-card-text>
                            <v-select v-model="rateup.rating" :items="rating" :rules="[v=> !!v || 'โปรดให้คะแนนการใช้งานของท่าน']" label="ให้คะแนนการใช้งาน :"></v-select>
                        </v-container>
                    
                     <v-card-actions>
                        <v-container>
                            <v-btn color="success" dark @click="sentRateUP">ส่ง</v-btn>
                            <v-btn color="error" class="mr-4" @click="reset">ล้างฟอร์ม</v-btn>
                        </v-container>
                     </v-card-actions>
                </v-form>
            </v-container>
            <v-snackbar v-model="snackbar">
      {{ message }}
      <v-btn text color="primary" @click="snackbar = !snackbar">ปิด</v-btn>
    </v-snackbar>
        </v-card>
    </v-app>

</template>

<script>
import RateUPController from "../controller/RateUPController";
export default {
    data: () =>({
        snackbar: false,
        rateup:{
            email: null,
            suggestion: null,
            status: null,
            edlevel: null,
            rating: null
        },
        status: [],
        edlevel:[],
        rating:[],
        message: ''
    }),
    methods: {
        reset: function () {
            this.$refs.form.reset();
        },
        sentRateUP: function () {
            RateUPController
                .sentRateUP(this.rateup)
                .then(response => {
                    this.$log.debug(this.rateup);
                    this.message = "สำเร็จ ^^";
                    this.$log.debug("Sent Complete !! ", response.data)
                })
                 .catch(error => {
                    this.message = "ส่งไม่สำเร็จ !!";
                    this.$log.debug(error.response.data.message);
                    })
                .finally(() => {
                    this.snackbar = !this.snackbar;
                    this.reset();
                    });
        }

    },
     mounted() {
        RateUPController.getStatus().then(response => {
            this.$log.debug(response.data);
            response.data.forEach(snapshot => {
                this.status.push({
                    text: snapshot.status,
                    value: snapshot.id
                });
            });
        }),
        RateUPController.getEdLevel().then(response => {
            this.$log.debug(response.data);
            response.data.forEach(snapshot => {
                this.edlevel.push({
                    text: snapshot.edlevel,
                    value: snapshot.id
                });
            });
        }),
        RateUPController.getRating().then(response => {
            this.$log.debug(response.data);
            response.data.forEach(snapshot => {
                this.rating.push({
                    text: snapshot.rating,
                    value: snapshot.id
                });
            });
        });
     }
    
}
</script>