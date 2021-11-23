<template>
  <div class="container">
    <h1 class="title">Search</h1>
    <h2 class="subtitle">Search for company (8 digits) or name</h2>
    
    <SearchBar @search-string="performSearch" />
    <SearchResults />
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';
import SearchBar from "@/components/SearchBar.vue";
import SearchResults from "@/components/SearchResults.vue";


export default {
  components: {
    SearchBar,
    SearchResults
  },
  computed: {
    ...mapGetters('search', ['searchResults'])
  },
  methods: {
    ...mapActions('search',['search']),
    performSearch(searchString) {
      this.search(searchString);
    }
  }
  

};
</script>
