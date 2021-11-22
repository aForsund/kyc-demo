<template>
  <div class="card notification is-info">
    <div class="card-content">
      <div class="field">
        <div class="control">
          <input class="input" v-model="text" type="text" @keyup.enter="sendRequest" />
        </div>
        <button v-on:click="sendRequest" class="button is-link mt-2">Search</button>
      </div>
    </div>
  </div>
</template>


<script>
export default {
  data() {
    return {
      text: ""
    };
  },
  methods: {
    sendRequest() {
      this.$emit("search-string", this.text);
    }
  }
};
</script>

<style scoped>
.button {
  transition: all 0.4s;
}
</style>