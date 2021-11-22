<template>
  <div>
    
    <h2 class="subtitle" v-if="infoText != null">{{ infoText }}</h2>
    <div class="container" v-if="searchResults != null">
      <SearchResult  v-for="(result, index) in searchResults" :key="index" :result="result" />
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

import SearchResult from "./SearchResult.vue";

export default {
  components: {
    SearchResult
  },
  computed: {
    ...mapGetters('search', ['searchResults', 'infoText'])
  }
};
</script>