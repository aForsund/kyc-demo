<template>
  <div class="container">
    <div class="columns is-variable is-multiline is-3">
      <router-link class="button is-primary m-2" :to="{ name: 'search' }">Search
      </router-link>
      <button class="button is-primary m-2">DashBoard</button>
      <button class="button is-primary m-2">Customers</button>
      <button class="button is-primary m-2">Reset DB</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "NavBarSelectionMenu"
};
</script>