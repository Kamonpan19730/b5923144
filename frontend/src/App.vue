<template>

  <v-app>
    <v-app-bar app color="pink" dark  src="">
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      
      <v-toolbar-title>ระบบห้องสมุด</v-toolbar-title>
        <v-toolbar-items>
         <v-divider inset vertical></v-divider>
         
      


      </v-toolbar-items>

        <div class="flex-grow-1"></div>


      <v-toolbar-items>
        <v-btn text to="/home">Home</v-btn> <v-divider inset vertical></v-divider>
         <v-divider inset vertical></v-divider>
         <v-btn text to="/Member">ลงทะเบียนสมาชิก</v-btn> <v-divider inset vertical></v-divider>
        <v-btn text to="/AddBook">เพิ่มหนังสือ</v-btn> <v-divider inset vertical></v-divider>
        <v-btn text to="/addVideo">เพิ่มวิดีโอ</v-btn> <v-divider inset vertical></v-divider>
        <v-btn text to="/borrow">ยืมหนังสือ</v-btn> <v-divider inset vertical></v-divider>
        <v-btn text to="/remand">คืนหนังสือ</v-btn> <v-divider inset vertical></v-divider>
        <v-btn text to="/rates">ให้คะแนน</v-btn> <v-divider inset vertical></v-divider>
       <v-divider inset vertical></v-divider>


      </v-toolbar-items>
    </v-app-bar>

    <v-content>
      
      <router-view />
    </v-content>
  </v-app>
</template>







