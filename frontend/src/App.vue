<template>
  <v-app>
    <v-app-bar app color="blue darken-2" dark>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>ระบบห้องสมุด</v-toolbar-title>
        <div class="flex-grow-1"></div>

      <v-toolbar-items>
        
        <v-btn text to="/rates">ให้คะแนน</v-btn>
        <v-btn text to="/Member">สมาชิก</v-btn>
        <v-btn text to="/addVideo">เพิ่มวิดีโอ</v-btn>
        <v-btn text to="/AddBook">เพิ่มหนังสือ</v-btn>
        <v-btn text to="/borrow">ยืมหนังสือ</v-btn>
        <v-btn text to="/remand">คืนหนังสือ</v-btn>
        
      </v-toolbar-items>
    </v-app-bar>

    <v-content>
      
      <router-view />
    </v-content>
  </v-app>
</template>

<script>


export default {
  name: 'App',

  components: {
   
  },

  data: () => ({
    //
  }),

};
</script>
