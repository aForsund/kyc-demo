<template>
  <div>
    
    <h2 class="subtitle" v-if="infoText != null">{{ infoText }}</h2>
    <div class="container" v-if="searchResults != null">
      <div v-if="searchResults.number">
        <Company :result="searchResults" />
      </div>
      <div v-else>
        <PEP  v-for="(result, index) in searchResults" :key="index" :person="result" />
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

import PEP from "./PEP.vue";
import Company from "./Company.vue";

export default {
  components: {
    PEP,
    Company
  },
  computed: {
    ...mapGetters('search', ['searchResults', 'infoText'])
  }
};
</script>