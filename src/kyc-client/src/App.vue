<template>
  <section id="app" class="hero is-dark is-fullheight is-bold">
    <div class="hero-head">
      <NavBar />
      <NavBarSelectionMenu />
    </div>
    <div class="hero-body">
      <router-view />
    </div>
    <div class="hero-foot has-text-right">
      <span>
        <a href="https://bulma.io">
          <img
            src="https://bulma.io/images/made-with-bulma--white.png"
            alt="Made with Bulma"
            width="128"
            height="24"
          />
        </a>
      </span>
    </div>
  </section>
</template>

<script>

import NavBar from "@/components/NavBar.vue";
import NavBarSelectionMenu from "@/components/NavBarSelectionMenu.vue";

export default {
  components: {
    NavBar,
    NavBarSelectionMenu
  },
};

</script>

<style>
@import "~bulma/css/bulma.css";
</style>
