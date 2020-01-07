<template>
  <v-app>
    <v-app-bar
      app
      class="teal accent-2"
    >
      <div class="d-flex align-center">
        <v-img
          alt="Vuetify Logo"
          class="shrink mr-2"
          contain
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"
          transition="scale-transition"
          width="40"
        />

        <span>ระบบให้คะแนนการใช้งาน</span>
      </div>

      <v-spacer></v-spacer>

      <v-btn
        href="https://www.facebook.com/inexact"
        target="_blank"
        text
      >
        <span>Contact Me</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn>
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
