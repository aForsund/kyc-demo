<template>
  <div>
    
    <p v-if="infoText != null">{{ infoText }}</p>
    <div v-if="searchResults != null">
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