<template>
  <div class="box is-primary">
    <h1 class="title has-text-dark">{{ result.name }}</h1>
    <h2 class="subtitle has-text-dark">OrgNr {{ result.number }}</h2>
    <div v-for="(person, index) in result.persons" :key="index">
      <div class="notification is-primary mt-2 mb-2" v-bind:class="{ 'is-danger' : person.isPEP }">
        <p class="is-size-4">{{ person }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    result: [Object, String, Array]
  }
};
</script>